package Controller;

import Exception_Test.IdException;
import Exception_Test.NameException;
import Model.Department;
import Model.Employee;
import Service.Department.DepartmentService;
import Service.Employee.EmployeeService;
import Service.Menu.MenuService;

import java.util.Scanner;

public class Demo {
    private static Scanner sc = new Scanner(System.in);
    private static DepartmentService departmentService = new DepartmentService();
    private static EmployeeService employeeService = new EmployeeService();

    //---------------------------main------------------
    public static void main(String[] args) throws IdException, NameException {
        int checkDepart = 0, checkEm = 0;
        //-------------------------------------------------
        while (true){
            MenuService.menu();
            checkDepart = 0;
            checkEm = 0;
            System.out.print("Lựa chọn: ");
            int choose = Integer.parseInt(sc.nextLine());
            //------------------phòng ban
            if(choose == 1){
                while (checkDepart == 0){

                    MenuService.menuDepartment();
                    System.out.print("Lựa chọn: ");
                    int chooseDepart = Integer.parseInt(sc.nextLine());
                    switch (chooseDepart){
                        case 1:
                            departmentService.displayAll();
                            break;
                        case 2:
                            System.out.print("Nhập tên muốn tìm: ");
                            String name = sc.nextLine();
                            departmentService.displayByName( name);
                            break;
                        case 3:
                            System.out.println("Nhập thông tin phòng ban muốn nhập");
                            Department department = (Department) departmentService.inputOne();
                            try {
                                departmentService.add( department);
                            }catch (NameException f){
                                System.out.println(f);
                            }catch (IdException e){
                                System.out.println(e);
                            }
                            break;
                        case 4:
                            System.out.print("Nhập id muốn sửa: ");
                            String idToEdit = sc.nextLine();
                            departmentService.editById(idToEdit);
                            break;
                        case 5:
                            System.out.print("Nhập id muốn xóa: ");
                            String idToDelete = sc.nextLine();
                            departmentService.deleteById( idToDelete);
                            break;
                        case 6:
                            departmentService.displayRoomFree();
                            break;
                        case 7:
                            departmentService.displayRoomHas();
                            break;
                        case 8:
                            departmentService.addOneEmployee();
                            break;
                        case 9:
                            departmentService.deleteOneEmployee();
                            break;
                        case 10:
                            departmentService.displayStatic();
                            break;
                        case 11:
                            departmentService.displayStaticRoom();
                            break;
                        case 12:
                            checkDepart = 1;
                            break;
                        case 13:
                            System.out.println("Thoát chương trình");
                            System.exit(0);
                    }
                }
            }
            //----------------------------Nhân sự
            else if (choose == 2) {
                while (checkEm == 0){

                    MenuService.menuEmployee();
                    System.out.print("Lựa chọn: ");
                    int chooseEmp = Integer.parseInt(sc.nextLine());
                    switch (chooseEmp){
                        case 1:
                            employeeService.displayAll();
                            break;
                        case 2:
                            System.out.print("Nhập tên muốn tìm: ");
                            String name = sc.nextLine();
                            employeeService.displayByName( name);
                            break;
                        case 3:
                            System.out.println("Nhập thông tin nhân viên muốn thêm");
                            Employee employee = (Employee) employeeService.inputOne();
                            employeeService.add( employee);
                            break;
                        case 4:
                            System.out.print("Nhập id muốn sửa: ");
                            String idToEdit = sc.nextLine();
                            employeeService.editById( idToEdit);
                            break;
                        case 5:
                            System.out.print("Nhập id muốn xóa: ");
                            String idToDelete = sc.nextLine();
                            employeeService.deleteById( idToDelete);
                            break;
                        case 6:
                            employeeService.displayEmpFree();
                            break;
                        case 7:
                            employeeService.displayEmpHas();
                            break;
                        case 8:
                            employeeService.displayStatic();
                            break;
                        case 9:
                            employeeService.displayStaticEmp();
                            break;
                        case 10:
                            checkEm = 1;
                            break;
                        case 11:
                            System.out.println("Thoát chương trình");
                            System.exit(0);
                    }
                }
            } else if (choose == 3) {
                System.out.println("Thoát chương trình");
                System.exit(0);
            }

        }
    }
}
