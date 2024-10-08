package p1_io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ex1_fileInputStream {



    public static void main(String[] args) throws IOException {
        try (FileInputStream fileIn = new FileInputStream("src/p1_io/input.txt")){
            int data;
            while( (data = fileIn.read()) != -1){
                System.out.print((char) data);
            }
        }catch (IOException e) {
            System.out.println("Err: " + e);
        }
    }
}
