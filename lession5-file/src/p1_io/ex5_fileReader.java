package p1_io;

import java.io.FileReader;
import java.io.IOException;

public class ex5_fileReader {
    public static void main(String[] args) throws IOException {
        try (FileReader fRead = new FileReader("src/p1_io/input.txt")){
            System.out.println(fRead);

            int c;
            while ( (c = fRead.read()) !=-1) {
                System.out.println((char) c);
            }
        }catch (IOException e){
            System.out.println(e);
        }
    }
}
