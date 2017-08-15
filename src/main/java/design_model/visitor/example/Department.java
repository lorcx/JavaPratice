package design_model.visitor.example;

/**
 * 抽象部门类
 * Created by Administrator on 2017/8/15 0015.
 */
public abstract class Department {
    // 访问不同类型元素
   public abstract void visit(FullTimeEmployee employee);
   public abstract void visit(ParttimeEmployee employee);
}
