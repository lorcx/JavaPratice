package design_model.visitor.example;

/**
 * 人力资源部
 * Created by Administrator on 2017/8/15 0015.
 */
public class HRDepartment extends Department{

    /**
     * 实现人力资源部对全职员工的访问
     * @param employee
     */
    @Override
    public void visit(FullTimeEmployee employee) {
        int workTime = employee.getWorkTime();
        System.out.println("正式员工：" + employee.getName() + " 实际工作时间：" + workTime + "小时。");

        if (workTime > 40) {
            System.out.println("正式员工：" + employee.getName() + "加班时间：" + (workTime - 40) + "小时。");
        }

        if (workTime < 40) {
            System.out.println("正式员工：" + employee.getName() + "请假时间：" + (40 - workTime) + "小时。");
        }

    }

    /**
     * 实现人力资源部对临时工的访问
     * @param employee
     */
    @Override
    public void visit(ParttimeEmployee employee) {
        int workTime = employee.getWorkTime();
        System.out.println("正式员工：" + employee.getName() + " 实际工作时间：" + workTime + "小时。");
    }
}
