package student;

import java.util.Scanner;

public class Main {
    //---------khai báo static

    private static Scanner sc = new Scanner(System.in);
    static Student[] dssv = new Student[1000];
    static int LengthSv = 0;

    //-------------------------------------------------
    public static void main(String[] args) {
        StudentManager.init(dssv);
//        LengthSv = 5;

        while (true){
            StudentManager.menu();
            System.out.print("Lựa chọn của bạn: ");
            int lcMenu = Integer.parseInt(sc.nextLine());
            switch (lcMenu){
                case 0:
                    System.out.println("Kết thúc chương trình");
                    System.exit(0);
                case 1:
                    StudentManager.displayST(dssv, Student.getSize());
                    break;
                case 2:
                    System.out.print("nhập id cần tìm: ");
                    String idSearch = sc.nextLine();
                    System.out.print("nhập tên cần tìm: ");
                    String nameSearch = sc.nextLine();
                    StudentManager.getStByNameAndId(dssv, Student.getSize(), nameSearch, idSearch);
                    break;
                case 3: //thêm sv
                    Student studentAdd = StudentManager.input1St();
                    StudentManager.addStudent(dssv, Student.getSize(), studentAdd);
//                    LengthSv++;
                    break;
                case 4:   //sua thong tin
                    System.out.print("Nhap id muon sua: ");
                    String id = sc.nextLine();
                    int pos = StudentManager.findStudentById(dssv, Student.getSize(), id);
                    Student studentEdit = StudentManager.input1St();
                    StudentManager.editStudent(dssv, pos, studentEdit);
                    break;
                case 5: //xoa id
                    System.out.print("Nhap id muon xoa: ");
                    String idRemove = sc.nextLine();
                    int posDelete = StudentManager.findStudentById(dssv, Student.getSize(), idRemove);
                    StudentManager.deleteStudentById(dssv, Student.getSize(), posDelete);
//                    LengthSv--;
            }
        }
    }
}
