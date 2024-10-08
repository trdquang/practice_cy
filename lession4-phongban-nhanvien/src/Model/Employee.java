package Model;

public class Employee {
    private String id;
    private String name;
    private int age;
    private String dob;
    private String phoneNumber;
    private String workAs;
    private String departId = null;
    private StringBuilder store = new StringBuilder("");

    private static int length = 0;

    public Employee() {
        this.departId = null;
    }

    public Employee(String id, String name, int age, String dob, String phoneNumber, String workAs) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.dob = dob;
        this.phoneNumber = phoneNumber;
        this.workAs = workAs;
        this.departId = null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getWorkAs() {
        return workAs;
    }

    public void setWorkAs(String workAs) {
        this.workAs = workAs;
    }

    public static int getLength() {
        return length;
    }

    public static void setLength(int length) {
        Employee.length = length;
    }

    public String getDepartId() {
        return departId;
    }

    public void setDepartId(String departId) {
        this.departId = departId;
    }

    public StringBuilder getStore() {
        return store;
    }

    public void setStore(StringBuilder store) {
        this.store = store;
    }

    public void toStringEmployee(){
        System.out.printf("%-5s,%-15s, %-5d, %-10s, %-15s, %-15s\n", id, name, age, dob, phoneNumber, workAs);
    }
}
