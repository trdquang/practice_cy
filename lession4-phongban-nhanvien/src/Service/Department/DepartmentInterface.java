package Service.Department;

import Model.Department;
import Model.Employee;
import Service.BaseService;

public interface DepartmentInterface extends BaseService {
    void displayRoomHas();
    void displayRoomFree();
    void addOneEmployee( );
    void deleteOneEmployee( );
    void displayStatic();
}
