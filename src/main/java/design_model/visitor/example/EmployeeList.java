package design_model.visitor.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/15 0015.
 */
public class EmployeeList {

    private List<Employee> list = new ArrayList<>();

    /**
     * 添加一个员工
     * @param e
     */
    public void addEmployee(Employee e) {
        list.add(e);
    }

    /**
     * 遍历集合中的每一个对象
     */
    public void accept(Department handler) {
        for (Object obj : list) {
            ((Employee)obj).accept(handler);
        }
    }

}
