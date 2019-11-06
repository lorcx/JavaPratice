package tools.powermock;

/**
 * @Author: lx
 * @Date: Created in 2019/8/14 0014
 */
public class EmployeeService {
    public int getEmployeeCount() {
        return EmployeeUtils.getEmployeeCount();
    }
    public void createEmployee(Employee employee) {
        EmployeeUtils.persistenceEmployee(employee);
    }
}
