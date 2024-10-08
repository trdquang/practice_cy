package p1_io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ex2_fileOutputStream {
    public static void main(String[] args) throws IOException {
        try (FileOutputStream fOut = new FileOutputStream("src/p1_io/output.txt", true);
             FileInputStream fileIn = new FileInputStream("src/p1_io/input.txt")){

            byte[] bytes = fileIn.readAllBytes();

            // Chuyển đổi byte thành chuỗi ký tự
//            String content = new String(bytes);

            fOut.write(bytes);
        }catch (IOException e){
            System.out.println("Lỗi: " + e);
        }
    }
}
