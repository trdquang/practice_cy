package Service.Department;

import Exception_Test.NameException;
import Model.Department;
import Model.Employee;
import Service.Employee.EmployeeService;
import Exception_Test.IdException;

import java.util.Scanner;
import java.util.StringTokenizer;

public class DepartmentService implements DepartmentInterface{
    private static Department[]departments = new Department[1000];
    private  Scanner sc = new Scanner(System.in);
    private  EmployeeService employeeService = new EmployeeService();

    public DepartmentService() {
        departments[0] = new Department("DP01", "Sale", 2, null);
        departments[1] = new Department("DP02", "Marketing", 1, null);
        departments[2] = new Department("DP03", "Developer", 2, null);
        departments[3] = new Department("DP04", "HR", 3, null);
        departments[4] = new Department("DP05", "Finance", 3, null);

        Department.setLength(5);
    }

    //-------------------Nhập 1

    @Override
    public Object inputOne() {
        System.out.print("id: ");
        String id = sc.nextLine();
        System.out.print("name: ");
        String name = sc.nextLine();
        System.out.print("floor: ");
        int floor = Integer.parseInt(sc.nextLine());
        Department department = new Department(id, name, floor, null);
        return department;
    }

    @Override
    public void displayByName( String name) {
            for (int i = 0; i < Department.getLength(); i++) {
                if(this.departments[i].getName().equalsIgnoreCase(name)){
                    this.departments[i].toStringDepartment();
                }
            }
    }

    @Override
    public int findById( String id) {
            for (int i = 0; i < Department.getLength(); i++) {
                if(this.departments[i].getId().equalsIgnoreCase(id)){
                    return i;
                }
            }
        return -1;
    }

    @Override
    public int findByName( String name) {
        for (int i = 0; i < Department.getLength(); i++) {
            if(this.departments[i].getName().equalsIgnoreCase(name)){
                return i;
            }
        }
        return -1;
    }

    //-------------------Thêm 1

    @Override
    public void add(Object object) throws IdException, NameException {
        if(Department.getLength() == 999)
            System.out.println("Không thể thêm phòng ban");
        else{
            if(object instanceof Department) {
                int posId = findById( ((Department) object).getId() );
                if(posId != -1)
                    throw new IdException("Id trùng");

                int posName = findByName( ((Department) object).getName() );
                if(posName != -1)
                    throw new NameException("Name trùng");
            }

            this.departments[Department.getLength()] = (Department) object;
            Department.setLength(Department.getLength()+1);
        }
    }

    @Override
    public void editById( String id) {
            int pos = findById(id);
            if(pos == -1)
                System.out.println("Không có phòng ban này");
            else{
                Department object = (Department) inputOne();
                this.departments[pos] =  object;
            }
    }

    @Override
    public void deleteById( String id) {

            int pos = findById(id);
            if(pos == -1)
                System.out.println("Không có phòng ban này");
            else{
                if(departments[pos].getEmployee() != null)
                    departments[pos].getEmployee().setDepartId(null);
                for(int i = pos; i < Department.getLength(); i++){
                    departments[i] = departments[i+1];
                }
                Department.setLength(Department.getLength()-1);

            }
    }

    @Override
    public void displayAll() {
        for (int i = 0; i < Department.getLength(); i++) {
            this.departments[i].toStringDepartment();
        }
    }

    @Override
    public void displayRoomHas() {
        for (int i = 0; i < Department.getLength(); i++) {
            if(departments[i].getEmployee() != null)
                departments[i].toStringDepartment();
        }
    }

    @Override
    public void displayRoomFree() {
            for (int i = 0; i < Department.getLength(); i++) {
                if(departments[i].getEmployee() == null)
                    departments[i].toStringDepartment();
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

    public void displayStaticRoom(){
        int max = -1;
//        System.out.println((departments[0].getStore()));
//        max = count( new String(departments[0].getStore()));
        for(int i = 0; i < Department.getLength(); i++){
            if(count( new String(departments[i].getStore())) >= max )
                max = count(new String(departments[i].getStore()));
        }

//        System.out.println("mã  =" + max);

        for(int i = 0; i < Department.getLength(); i++){
            if(count( new String(departments[i].getStore())) == max )
                System.out.printf("%-10s............%-30s\n", departments[i].getName(), departments[i].getStore());
        }
    }

    @Override
    public void addOneEmployee() {
        System.out.print("Nhập id phòng muốn thêm người: ");
        String id = sc.nextLine();
            int pos = findById( id);
            if(pos == -1 || departments[pos].getEmployee() != null){
                System.out.println("id phòng không hợp lệ");
            }else{
                Employee[] employee = employeeService.getEmployees();
                System.out.println("Chọn 1 nhân viên trong số các nhân viên chưa có phòng");
                    employeeService.displayEmpFree();

                    System.out.print("Nhập id nhân viên muốn thêm: ");
                    String idAdd = sc.nextLine();
                    int posAdd = employeeService.findById(idAdd);
                    if(posAdd == -1 || employee[posAdd].getDepartId()!= null){
                        System.out.println("Nhân viên không hợp lệ");
                    }else{
                        departments[pos].setEmployee(employee[posAdd]);
                        employee[posAdd].setDepartId(departments[pos].getId());
                        departments[pos].setStore(departments[pos].getStore().append(";*!").append(employee[posAdd].getName()));
                        employee[posAdd].setStore(employee[posAdd].getStore().append(";*!").append(departments[pos].getName()));
                    }
            }

    }

    @Override
    public void deleteOneEmployee() {
        System.out.print("Nhập id phòng muốn xóa người: ");
        String id = sc.nextLine();
        int pos = findById( id);
        if(pos == -1 || departments[pos].getEmployee() == null){
            System.out.println("id phòng không hợp lệ");
        }else {
            departments[pos].getEmployee().setDepartId(null);
            departments[pos].setEmployee(null);
        }
    }

    @Override
    public void displayStatic(){
        System.out.println("Tên phòng ban và danh sách nhân viên");
        for(int i = 0; i < Department.getLength(); i++){
            System.out.printf("%-10s............%-30s\n", departments[i].getName(), departments[i].getStore());
        }
    }
}
