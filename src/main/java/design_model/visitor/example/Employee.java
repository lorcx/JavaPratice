package design_model.visitor.example;

/**
 * Created by Administrator on 2017/8/15 0015.
 */
public interface Employee {
    // 接受一个抽象的访问者访问
    void accept(Department handler);
}
