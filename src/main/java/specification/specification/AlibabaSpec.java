package specification.specification;// 包名小写

import java.util.Objects;

/**
 * alibaba Java 编码规范
 * Created by Administrator on 2017/2/12 0012.
 */
public class AlibabaSpec {// 类名大写

    int n;
    Integer n1;


    // 枚举大写
    enum Type {
        FLAG_A,
        FLAG_B,
        FLAG_C
    }

    String SUCCESS_FLAG = "success";// 常量名大写 _ 分割单词

    /**
     * 没有必要不要写public
     */
    void method () {
        Long num = 1L; // L 大写 防止混淆
        Long num2 = 1L;

        num.equals(num2);// 用下面的代替 这个方法会有空指针的发生  jdk 1.7 新增方法
        System.out.println(Objects.equals(num, num2));

        // 所有引用类型都要用equals判断

        // pojo 是 DO VO BO DTO的统称

        // pojo 中的属性不要赋值

        // pojo 必须重写toString方法，这样在方法报错直接用这个方法打印便于排查

        /*
         *  pojo 用包装数据类型：提醒使用者自己进行显示的赋值，任何NEP，或者入库检查，都有使用者来保证。
         *
         *  局部变量用 基本数据类型：使用包装类影响性能
         *
         *  rpc返回用包装类型：假如用数据库查询返回基本类型，出错赋了初始值0,那么就不容易分辨出是报错，还是就应该是0
         *  如果用包装数据类型，返回null 那么就多了一种状态，知道是报错了。
         */

        // 构造方法不要写任何业务逻辑 ，如果有初始化逻辑 把它放到init里


        // 同名方法放到一起


        // 类定义方法顺序是：共有方法 > 私有方法 > get set 方法  最需要看到的方法在前边

    }


    public static void main(String[] args) {
        AlibabaSpec ab = new AlibabaSpec();
        ab.method();

        System.out.println(ab.n);
        System.out.println(ab.n1);
//        ab.n = ab.n1;
        ab.n1 = ab.n;
        System.out.println(ab.n1);

        String str = "1,2,3,,";
        String[] arr = str.split(",");
        // 使用split的时候要进行边界检查 期望结果>3 实际 结果=3
        System.out.println(arr.length);

    }
}
