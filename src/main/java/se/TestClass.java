package se;

/**
 * finally 中不加return 返回结果不一样
 *
 * @Author lx
 * @Date 2019/1/26 11:21
 */
public class TestClass {
    public static void main(String[] args) {
        System.out.println(new TestClass().inc());
    }

    public int inc() {
        int x;
        try {
            x = 1;
            x = 1 / 0;
            return x;
        } catch (Exception e) {
            x = 2;
            return x;
        } finally {
            x = 3;
            //return x;
        }
    }
}
