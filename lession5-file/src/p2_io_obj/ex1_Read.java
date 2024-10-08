package p2_io_obj;

import p2_io_obj.model.Student;

import java.io.*;

public class ex1_Read {
    public static void main(String[] args) throws IOException {
        try  (FileInputStream fint = new FileInputStream("src/p2_io_obj/output.txt");
              ObjectInputStream in = new ObjectInputStream(fint);
        ) {
             while (true){
                 Student tmp = (Student) in.readObject();
                 System.out.println(tmp.toString());
             }
         }catch (EOFException e) {
            // Khi gặp EOF, thoát khỏi vòng lặp
            System.out.println("Đã hoàn tất việc đọc đối tượng.");
        } catch (IOException e) {
            System.out.println("Lỗi I/O: " + e);
        } catch (ClassNotFoundException e) {
            System.out.println("Lớp không tìm thấy: " + e);
        }
    }
}
