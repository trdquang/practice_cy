package p1_io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ex6_fileWritter {
    public static void main(String[] args) throws IOException {
        try ( FileReader fRead = new FileReader("src/p1_io/input.txt");
        FileWriter fWriter = new FileWriter("src/p1_io/output.txt") ){
            int c;
            while (  (c = fRead.read())!=-1){
                fWriter.append((char) c);
            }

        }catch (IOException e){
            System.out.println(e);
        }
    }
}
