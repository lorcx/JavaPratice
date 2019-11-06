package tools.powermock.verify;

import tools.powermock.Employee;

/**
 * @Author: lx
 * @Date: Created in 2019/8/15 0015
 */
public class EmployeeDao {
    public void saveEmployee(Employee employee) {
        throw new UnsupportedOperationException();
    }
    public void updateEmployee(Employee employee) {
        throw new UnsupportedOperationException();
    }
    public long getCount(Employee employee) {
        throw new UnsupportedOperationException();
    }
}
