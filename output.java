import java.io.*;
public class Example {
    public static void main(String[] args) throws Exception{//block number 1
		File output = new File("output.txt");
		output.createNewFile();
		FileWriter w = new FileWriter("output.txt");
		w.write("block 1 is Visited " +"\n");

            int x=5;
            if(x==5){//block number 2

                System.out.println(x);
            w.write("block 2 is Visited" +"\n");
}
            else{//block number 3

                System.out.println("error");
            w.write("block 3 is Visited" +"\n");
}
            for(int i=0;i<x;i++){//block number 4

            w.write("block 4 is Visited" +"\n");
}


    w.close();
}
}
