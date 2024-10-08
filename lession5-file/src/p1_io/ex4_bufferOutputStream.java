package p1_io;

import java.io.*;

public class ex4_bufferOutputStream {
    public static void main(String[] args) throws IOException{
        try (BufferedOutputStream fOut = new BufferedOutputStream(new FileOutputStream("src/p1_io/output.txt", true));
             BufferedInputStream fileIn = new BufferedInputStream(new FileInputStream("src/p1_io/input.txt"))){

            byte[] bytes = fileIn.readAllBytes();
            System.out.println(new String(bytes));
            fOut.write(bytes);

        }catch (IOException e){
            System.out.println(e);
        }

    }
}
