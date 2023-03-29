import org.antlr.v4.runtime.TokenStreamRewriter;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.io.File;
import java.io.FileWriter;

public class blockListener extends JavaParserBaseListener{
    int i;
    TokenStreamRewriter rewriter;
    public blockListener(TokenStreamRewriter rewriter){
        this.rewriter = rewriter;
        this.i=0;
    }
    @Override public void enterBlock(JavaParser.BlockContext ctx) {

        this.i++;
        rewriter.insertAfter(ctx.getStart(),"//block number " + this.i+"\n");


        if(i==1) {
            rewriter.insertBefore(ctx.getStart(),"throws Exception");

            rewriter.insertAfter(ctx.getStart(),"\t"+"\t"+"File output = new File(\"output.txt\");"+"\n");
            rewriter.insertAfter(ctx.getStart(),"\t"+"\t"+"output.createNewFile();"+"\n");
            rewriter.insertAfter(ctx.getStart(),"\t"+"\t"+"FileWriter w = new FileWriter(\"output.txt\");"+"\n");
            rewriter.insertAfter(ctx.getStart(),"\t"+"\t"+"w.write(\"block "+ this.i + " is Visited \" +\"\\n\");"  +"\n");

            rewriter.insertBefore(ctx.getStop(),"w.close();"+"\n");
        }
        else{
            rewriter.insertBefore(ctx.getStop(),"w.write(\"block "+ this.i + " is Visited\" +\"\\n\");"  +"\n");
        }

    }
    @Override public void exitBlock(JavaParser.BlockContext ctx) {

    }
    @Override public void visitTerminal(TerminalNode node) {
        //System.out.println(node.getText());

    }

    @Override public void enterCompilationUnit(JavaParser.CompilationUnitContext ctx) {
        rewriter.insertBefore(ctx.getStart(),"import java.io.File;"+"\n");
        rewriter.insertBefore(ctx.getStart(),"import java.io.FileWriter;"+"\n");
        rewriter.insertBefore(ctx.getStart(),"import java.io.IOException;"+"\n");
    }
}
