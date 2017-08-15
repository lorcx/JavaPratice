package design_model.visitor.example;

/**
 * 财务部类 具体的访问者
 * Created by Administrator on 2017/8/15 0015.
 */
public class FADepartment extends Department {

    /**
     * 实现财务部对全职员工的访问
     * @param employee
     */
    @Override
    public void visit(FullTimeEmployee employee) {
        int workTime = employee.getWorkTime();
        double weeklyWage = employee.getWeeklyWage();

        // 超过40算加班
        if (workTime > 40) {
            weeklyWage = weeklyWage + (workTime - 40) * 100;
        }

        // 小于40算请假
        if (workTime <= 40) {
            weeklyWage = weeklyWage - (40 - workTime) * 80;
            if (weeklyWage < 0) {
                weeklyWage = 0;
            }
        }

        System.out.println("正式员工：" + employee.getName() + " 实际工资：" + weeklyWage + "元");
    }

    /**
     * 实现财务部对临时工的访问
     * @param employee
     */
    @Override
    public void visit(ParttimeEmployee employee) {
        int workTime = employee.getWorkTime();
        double hourWage = employee.getHourWage();
        System.out.println("临时工：" + employee.getName() + " 实际工资：" + (workTime * hourWage) + "元");
    }
}
