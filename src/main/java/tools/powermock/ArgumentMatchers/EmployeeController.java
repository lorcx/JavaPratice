package tools.powermock.ArgumentMatchers;

/**
 * @Author: lx
 * @Date: Created in 2019/8/15 0015
 */
public class EmployeeController {
    public String getEmail(final String userName) {
        EmployeeService employeeService = new EmployeeService();
        String email = employeeService.findEmailByUserName(userName);
        return email;
    }
}
