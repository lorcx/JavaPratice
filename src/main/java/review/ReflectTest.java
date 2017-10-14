package review;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射创建对象
 * Created by lx on 2017/10/14.
 */
public class ReflectTest {
    private int n = 1;

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        // 方式一
        ReflectTest r = ReflectTest.class.newInstance();
        System.out.println(r.n);

        // 方式二
        ReflectTest r2 = (ReflectTest) ReflectTest.class.getConstructors()[0].newInstance();
        System.out.println(r2.n);

        new ReflectTest().invokeMethod();
    }

    public void invokeMethod() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String str = "hello";
        Method m = str.getClass().getMethod("toUpperCase");
        System.out.println(m.invoke(str));
    }
}
