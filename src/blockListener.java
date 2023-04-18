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

            rewriter.insertAfter(ctx.getStart(),"\t"+"\t"+"try{\n");
            rewriter.insertAfter(ctx.getStart(),"\t"+"\t"+"File output = new File(\"output.txt\");"+"\n");
            rewriter.insertAfter(ctx.getStart(),"\t"+"\t"+"output.createNewFile();"+"\n");

            rewriter.insertAfter(ctx.getStart(),"\t"+"\t"+"FileWriter w"+this.i+" = new FileWriter(\"output.txt\",true);"+"\n");
            rewriter.insertAfter(ctx.getStart(),"\t"+"\t"+"w"+this.i+".write(\"block "+ this.i + " is Visited\"+\"\\n\");"  +"\n");

            rewriter.insertAfter(ctx.getStart(),"\t"+"\t"+"w"+this.i+".close();"+"\n");
            rewriter.insertAfter(ctx.getStart(),"\t"+"\t"+"}catch (IOException e) {throw new RuntimeException(e);}\n");
        }
        else{
            rewriter.insertAfter(ctx.getStart(),"\t"+"\t"+"try{\n");
            rewriter.insertAfter(ctx.getStart(),"\t"+"\t"+"FileWriter w"+this.i+" = new FileWriter(\"output.txt\",true);"+"\n");
            rewriter.insertAfter(ctx.getStart(),"\t"+"\t"+"w"+this.i+".write(\"block "+ this.i + " is Visited\"+\"\\n\");"  +"\n");

            rewriter.insertAfter(ctx.getStart(),"\t"+"\t"+"w"+this.i+".close();"+"\n");
            rewriter.insertAfter(ctx.getStart(),"\t"+"\t"+"}catch (IOException e) {throw new RuntimeException(e);}\n");
        }

    }


    @Override public void enterCompilationUnit(JavaParser.CompilationUnitContext ctx) {
        rewriter.insertBefore(ctx.getStart(),"import java.io.File;"+"\n");
        rewriter.insertBefore(ctx.getStart(),"import java.io.FileWriter;"+"\n");
        rewriter.insertBefore(ctx.getStart(),"import java.io.IOException;"+"\n");
    }
}
