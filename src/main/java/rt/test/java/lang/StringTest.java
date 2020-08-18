package rt.test.java.lang;

/**
 * @Author: lx
 * @Date: Created in 2020/8/4
 */
public class StringTest {
    public static void main(String[] args) {
        String a = "a";
        System.out.println(a.codePointAt(0));

        a = "";
        System.out.println(a.isEmpty());

        System.out.println("abc".codePointBefore(2));
        System.out.println("abc".codePointCount(1,4));
        System.out.println("abc".codePointCount(1,4));
    }
}
