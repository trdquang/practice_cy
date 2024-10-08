package p1_io;

import java.io.*;

public class ex8_buferWritter {
    public static void main(String[] args) throws IOException {
        try  (  BufferedReader bfRead = new BufferedReader(new FileReader("src/p1_io/input.txt"));
                BufferedWriter bfWrite = new BufferedWriter(new FileWriter("src/p1_io/output.txt"))){

            String line;
            while ( (line = bfRead.readLine())!= null)
                bfWrite.write(line+"\n");

        }catch (IOException e){
            System.out.println(e);
        }
    }
}
