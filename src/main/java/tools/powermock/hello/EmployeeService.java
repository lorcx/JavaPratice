package tools.powermock.hello;

import tools.powermock.Employee;
import tools.powermock.EmployeeDao;

/**
 * @Author: lx
 * @Date: Created in 2019/8/14 0014
 */
public class EmployeeService {
    private EmployeeDao employeeDao;

    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    /**
     * 获取所有员工的数量.
     *
     * @return
     */
    public int getTotalEmployee() {
        return employeeDao.getTotal();
    }

    public void createEmployee(Employee employee) {
        employeeDao.addEmployee(employee);
    }
}
