package tools.powermock.constructors;

import tools.powermock.Employee;

/**
 * @Author: lx
 * @Date: Created in 2019/8/15 0015
 */
public class EmployeeDao {
    public enum Dialect {
        MYSQL,
        ORACLE
    }

    public EmployeeDao(boolean lazy, Dialect dialect) {
        throw new UnsupportedOperationException();
    }

    public void insertEmploye(Employee employee) {
        throw new UnsupportedOperationException();
    }
}
