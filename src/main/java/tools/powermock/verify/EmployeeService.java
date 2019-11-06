package tools.powermock.verify;

import tools.powermock.Employee;

/**
 * @Author: lx
 * @Date: Created in 2019/8/15 0015
 */
public class EmployeeService {
    public void saveOrUpdate(Employee employee) {
        final EmployeeDao employeeDao = new EmployeeDao();
        long count = employeeDao.getCount(employee);
        if (count > 0)
            employeeDao.updateEmployee(employee);
        else
            employeeDao.saveEmployee(employee);
    }
}
