package tools.powermock.constructors;

import tools.powermock.Employee;

/**
 * @Author: lx
 * @Date: Created in 2019/8/15 0015
 */
public class EmployeeService {
    public void createEmployee(final Employee employee) {
        EmployeeDao employeeDao = new EmployeeDao(false, EmployeeDao.Dialect.MYSQL);
        employeeDao.insertEmploye(employee);
    }
}
