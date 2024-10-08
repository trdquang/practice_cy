package Model;

public class Department {
    private String id;
    private String name;
    private int floor;
    private Employee employee;
    private StringBuilder store = new StringBuilder("");

    private static int length = 0;

    public Department() {
    }

    public Department(String id, String name, int floor, Employee employee ) {
        this.id = id;
        this.name = name;
        this.floor = floor;
        this.employee = employee;
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

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public static int getLength() {
        return length;
    }

    public static void setLength(int length) {
        Department.length = length;
    }

    public StringBuilder getStore() {
        return store;
    }

    public void setStore(StringBuilder store) {
        this.store = store;
    }

    public void toStringDepartment() {
        System.out.printf("%-10s%-15s%-5d", id, name, floor);
        if(this.employee != null){
            System.out.print("------------------");
            employee.toStringEmployee();
        }else{
            System.out.printf("\n");
        }
    }

}
