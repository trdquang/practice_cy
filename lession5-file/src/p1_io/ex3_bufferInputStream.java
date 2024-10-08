package p1_io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class ex3_bufferInputStream {
    public static void main(String[] args) throws IOException {
        try(BufferedInputStream bIn = new BufferedInputStream(new FileInputStream("src/p1_io/input.txt"))){
            int data;
            while ( (data = bIn.read()) != -1){
                System.out.print((char) data);
            }
        }catch (IOException e){
            System.out.println(e);
        }
    }
}
