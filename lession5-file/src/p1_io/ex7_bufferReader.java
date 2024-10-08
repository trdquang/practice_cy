package p1_io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ex7_bufferReader {
    public static void main(String[] args) throws IOException {
        try (BufferedReader bfRead = new BufferedReader(new FileReader("src/p1_io/input.txt"))) {
            String line;
            while ( (line = bfRead.readLine())!= null)
                System.out.println(line);
        }catch (IOException e){
            System.out.println(e);
        }
    }
}
