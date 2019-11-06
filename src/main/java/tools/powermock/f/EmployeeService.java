package tools.powermock.f;

import tools.powermock.Employee;

/**
 * @Author: lx
 * @Date: Created in 2019/8/15 0015
 */
public class EmployeeService {
    private EmployeeDao employeeDao;
    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
    public void createEmployee(Employee employee) {
        employeeDao.insertEmployee(employee);
    }
}
