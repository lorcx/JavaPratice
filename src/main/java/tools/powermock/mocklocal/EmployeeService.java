package tools.powermock.mocklocal;

import tools.powermock.Employee;
import tools.powermock.EmployeeDao;

/**
 * @Author: lx
 * @Date: Created in 2019/8/14 0014
 */
public class EmployeeService {
    public int getTotalEmployee() {
        EmployeeDao employeeDao = new EmployeeDao();
        return employeeDao.getTotal();
    }

    public void createEmployee(Employee employee) {
        EmployeeDao employeeDao = new EmployeeDao();
        employeeDao.addEmployee(employee);
    }
}
