package tools.powermock.privatemethod;

/**
 * @Author: lx
 * @Date: Created in 2019/8/15 0015
 */
public class EmployeeService {
    public boolean exist(String userName) {
        checkExist(userName);
        return true;
    }
    private void checkExist(String userName) {
        throw new UnsupportedOperationException();
    }
}
