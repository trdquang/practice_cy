package p2_io_obj;

import p2_io_obj.model.Student;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ex2_Write {
    public static void main(String[] args) throws IOException {
        try  (FileOutputStream fout = new FileOutputStream("src/p2_io_obj/output.txt");
              ObjectOutputStream out = new ObjectOutputStream(fout);
        ) {
            Student[] students = new Student[5];
            students[0] = new Student("st1", "Nguyễn Văn A");
            students[1] = new Student("st2", "Nguyễn Văn B");
            students[2] = new Student("st3", "Nguyễn Văn B");
            students[3] = new Student("st4", "Nguyễn Văn D");
            students[4] = new Student("st5", "Nguyễn Văn E");

            for(Student it: students)
                out.writeObject(it);

        }catch (IOException e){
            System.out.println(e);
        }
    }
}
