package student;

import java.util.Scanner;

public class StudentManager {
    static Scanner sc = new Scanner(System.in);

    public static void menu(){
        System.out.println("------------------CHUONG TRINH QUAN LY SINH VIEN------------------");
        System.out.println("1. Hiển thị danh sách sinh viên");
        System.out.println("2. Hiển thị sinh viên theo tên, id");
        System.out.println("3. Thêm sinh viên");
        System.out.println("4. Sửa thông tin sinh viên");
        System.out.println("5. Xóa sinh viên theo id");
        System.out.println("0. Thoát");
    }

    public static void init(Student[] st){
        st[0] = new Student("SV001", "Nguyen Van A", "Class A", 20, "2003-01-01");
        st[1] = new Student("SV002", "Tran Thi B", "Class B", 21, "2002-02-02");
        st[2] = new Student("SV003", "Le Van C", "Class C", 22, "2001-03-03");
        st[3] = new Student("SV004", "Pham Thi D", "Class D", 19, "2004-04-04");
        st[4] = new Student("SV005", "Hoang Van E", "Class E", 20, "2003-05-05");
        Student.setSize(5);
    }

    public static void displayST(Student[] stList, int idx){
        for (int i = 0; i < idx; i++)
            stList[i].toStringStudent();
    }

    public static void getStByNameAndId(Student[] stList, int idx, String name, String id){
        int cnt = 0;
        for (int i = 0; i < idx; i++){
            if(stList[i].getName().equalsIgnoreCase(name) && stList[i].getId().equalsIgnoreCase(id)){
                stList[i].toStringStudent();
            }
        }
    }

    //--------------Nhập sinh viên và thêm sinh viên---------------
    public static Student input1St(){
        Student st = new Student();
        System.out.print("Id: ");
        st.setId(sc.nextLine());
        System.out.print("name: ");
        st.setName(sc.nextLine());
        System.out.print("class: ");
        st.setClassName(sc.nextLine());
        System.out.print("age: ");
        st.setAge( Integer.parseInt(sc.nextLine()));
        System.out.print("dob: ");
        st.setDob(sc.nextLine());
        return st;
    }

    public static void addStudent(Student []st, int n, Student student){
        if(n == st.length){
            System.out.println("Danh sách đầy, không thể lưu trữ");
        }else{
            st[n] = new Student(student.getId(), student.getName(), student.getClassName(), student.getAge(),
                    student.getDob());
            Student.setSize(Student.getSize()+1);
            System.out.println("Thêm thành công");
        }
    }

    //------------------------tìm vị trí theo id
    public  static int findStudentById(Student[] st, int idx, String id){
        int res = -1;
        for(int i = 0; i < idx; i++){
            if(st[i].getId().equalsIgnoreCase(id))
                return i;
        }
        return -1;
    }

    //------sửa theo id
    public static void editStudent(Student[]st, int id, Student student){
        if(id != -1)
            st[id] = student;
    }

    public static void deleteStudentById(Student[]st, int ind, int indRemove){
        for(int i = indRemove; i < ind; i++){
            st[i] = st[i+1];
        }
        Student.setSize(Student.getSize()-1);
    }
}
