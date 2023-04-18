import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String inputFile = "Example.java";
        FileInputStream inputStream = new FileInputStream(inputFile);
        ANTLRInputStream input = new ANTLRInputStream(inputStream);
        JavaLexer lexer = new JavaLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        JavaParser parser = new JavaParser(tokens);
        ParseTree tree = parser.compilationUnit();
        ParseTreeWalker walker = new ParseTreeWalker();
        TokenStreamRewriter rewriter = new TokenStreamRewriter(tokens);
        //updateblocklistener is the class that add {} to blocks not contain {}
        walker.walk(new updateblocklistener(rewriter), tree);
        //convert blocks that not cotain {} from example.java and it it to new file edit.java
        File edit = new File("edit.java");
        edit.createNewFile();
        FileWriter w1 = new FileWriter("edit.java");
        w1.write(rewriter.getText());
        w1.close();
        /////////////////////////////////////////////////////////////////////////////////////
        inputFile = "edit.java";
        inputStream = new FileInputStream(inputFile);
        input = new ANTLRInputStream(inputStream);
        lexer = new JavaLexer(input);
        tokens = new CommonTokenStream(lexer);
        parser = new JavaParser(tokens);
        tree = parser.compilationUnit();
        walker = new ParseTreeWalker();

        rewriter = new TokenStreamRewriter(tokens);
        //convert edit.java to out put.java that will produce text file having blocks visited
        walker.walk(new blockListener(rewriter), tree);
        File output = new File("output.java");
        output.createNewFile();
        FileWriter wedit = new FileWriter("output.java");
        wedit.write(rewriter.getText());
        wedit.close();
        ////////////////////////////////////////////////////////////////////////////////////////

        //run output.java file to produce text file having each block visited
        Runtime rt = Runtime.getRuntime();
        Process pr = rt.exec("java output.java");
        try {
            pr.waitFor();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //-------------------------------------------------------------------------------------------------------------
            //html file part
            //System.out.println(rewriter.getText());

        inputFile = "edit.java";
        inputStream = new FileInputStream(inputFile);
        input = new ANTLRInputStream(inputStream);
        lexer = new JavaLexer(input);
        tokens = new CommonTokenStream(lexer);
        parser = new JavaParser(tokens);
        tree = parser.compilationUnit();
        walker = new ParseTreeWalker();
        rewriter = new TokenStreamRewriter(tokens);
        //swap > < with "&lt and &gt" in html file
        for (int i = 0; i < tokens.getTokens().size(); i++) {
            Token token = tokens.getTokens().get(i);
            if (token.getText().equals( "<")) {
                rewriter.replace(token, "&lt;");
            } else if (token.getText().equals(">")) {
                rewriter.replace(token, "&gt;");
            }
        }
        //create html file with colored block
        walker.walk(new htmlistener(rewriter), tree);

        File html = new File("final.html");
        html.createNewFile();
        FileWriter w2 = new FileWriter("final.html");
        w2.write(rewriter.getText());
        w2.close();




    }
}
