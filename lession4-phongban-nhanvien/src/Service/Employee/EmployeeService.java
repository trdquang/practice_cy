package Service.Employee;


import Model.Department;
import Model.Employee;

import java.util.Scanner;
import java.util.StringTokenizer;

public class EmployeeService implements EmployeeInterface{
    private static Employee[]employees = new Employee[1000];
    private static Scanner sc = new Scanner(System.in);

    public  Employee[] getEmployees() {
        return employees;
    }

    public static void setEmployees(Employee[] employees) {
        EmployeeService.employees = employees;
    }

    public EmployeeService() {
        employees[0] = new Employee("em01", "Alice", 30, "1993-01-01", "123456789", "Sales Representative");
        employees[1] = new Employee("em02", "Bob", 28, "1995-02-02", "987654321", "Marketing Specialist");
        employees[2] = new Employee("em03", "Charlie", 35, "1988-03-03", "456789123", "Software Developer");
        employees[3] = new Employee("em04", "David", 40, "1983-04-04", "321654987", "HR Manager");
        employees[4] = new Employee("em05", "Eva", 32, "1991-05-05", "159753468", "Finance Analyst");

        Employee.setLength(5);
    }

    @Override
    public Object inputOne() {
        System.out.print("ID: ");
        String id = sc.nextLine(); // Nhập ID

        System.out.print("Name: ");
        String name = sc.nextLine(); // Nhập tên

        System.out.print("Age: ");
        int age = Integer.parseInt(sc.nextLine()); // Nhập tuổi

        System.out.print("Date of Birth (yyyy-mm-dd): ");
        String dob = sc.nextLine(); // Nhập ngày sinh

        System.out.print("Phone Number: ");
        String phoneNumber = sc.nextLine(); // Nhập số điện thoại

        System.out.print("Work As: ");
        String workAs = sc.nextLine(); // Nhập chức vụ

        // Tạo đối tượng Employee và trả về
        Employee employee = new Employee(id, name, age, dob, phoneNumber, workAs);
        return employee;
    }

    @Override
    public void displayByName(String name) {
            for (int i = 0; i < Employee.getLength(); i++) {
                if(employees[i].getName().equalsIgnoreCase(name)){
                    employees[i].toStringEmployee();
                }
            }
    }

    @Override
    public int findById( String id) {
            for (int i = 0; i < Employee.getLength(); i++) {
                if(employees[i].getId().equalsIgnoreCase(id)){
                    return i;
                }
            }
        return -1;
    }

    @Override
    public int findByName( String name) {
        for (int i = 0; i < Employee.getLength(); i++) {
            if(employees[i].getName().equalsIgnoreCase(name)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public void add( Object object) {
        if(Employee.getLength() == 999)
            System.out.println("Không thể thêm nhân viên");
        else{
            employees[Employee.getLength()] = (Employee) object;
            Employee.setLength(Employee.getLength()+1);
        }
    }

    @Override
    public void editById( String id) {

            int pos = findById( id);
            if(pos == -1)
                System.out.println("Không có nhân viên này");
            else{
                Employee object = (Employee) inputOne();
                employees[pos] =  object;
            }
    }

    @Override
    public void deleteById( String id) {

            int pos = findById( id);
            if(pos == -1)
                System.out.println("Không có phòng ban này");
            else{
                for(int i = pos; i < Employee.getLength(); i++){
                    employees[i] = employees[i+1];
                }
                Employee.setLength(Employee.getLength()-1);
            }
    }

    @Override
    public void displayAll() {
            for (int i = 0; i < Employee.getLength(); i++) {
                employees[i].toStringEmployee();
            }
    }

    @Override
    public void displayEmpHas( ) {
            for (int i = 0; i < Employee.getLength(); i++) {
                if(employees[i].getDepartId() != null)
                    employees[i].toStringEmployee();
            }
    }

    @Override
    public void displayEmpFree() {
            for (int i = 0; i < Employee.getLength(); i++) {
                if(employees[i].getDepartId() == null)
                    employees[i].toStringEmployee();
            }
    }

    @Override
    public void displayStatic() {
        System.out.println("Tên nhân viên và danh sách phòng ban");
        for(int i = 0; i < Employee.getLength(); i++){
            System.out.printf("%-10s............%-30s\n", employees[i].getName(), employees[i].getStore());
        }
    }

    int count (String str){
        int cnt = 0;
        StringTokenizer token = new StringTokenizer(str, ";*!");

        // In ra từng phần tử
        while (token.hasMoreTokens()) {
            cnt++;
            token.nextToken();
        }
        return cnt;
    }

    public void displayStaticEmp(){
        int max = -1;
        for(int i = 0; i < Employee.getLength(); i++){
            if(count( new String(employees[i].getStore())) >= max )
                max = count(new String(employees[i].getStore()));
        }

        for(int i = 0; i < Employee.getLength(); i++){
            if(count( new String(employees[i].getStore())) == max )
                System.out.printf("%-10s............%-30s\n", employees[i].getName(), employees[i].getStore());
        }
    }
}
