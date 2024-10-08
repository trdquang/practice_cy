package Service.Employee;

import Model.Employee;
import Service.BaseService;

public interface EmployeeInterface extends BaseService {
    void displayEmpHas();
    void displayEmpFree();
    void displayStatic();
}
