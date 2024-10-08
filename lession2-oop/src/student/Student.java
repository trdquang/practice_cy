package student;

public class Student {

    private static int size = 0;

    public static int getSize() {
        return size;
    }

    public static void setSize(int size) {
        Student.size = size;
    }

    private String id;
    private String name;
    private String className;
    private int age;
    private String dob;

    public Student() {
    }

    public Student(String id, String name, String className, int age, String dob) {
        this.id = id;
        this.name = name;
        this.className = className;
        this.age = age;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public void  toStringStudent() {
        System.out.printf("%5s %15s %5s %5d %15s\n", id, name, className, age, dob);
    }
}
