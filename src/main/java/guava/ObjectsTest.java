package guava;

import com.google.common.base.Objects;

public class ObjectsTest {
    public static void main(String[] args) {
        System.out.println(Objects.equal(null, ""));

        Object o1 = null;
        Object o2 = null;
        Object o3 = new Object();
        System.out.println(o1 == o2);
        System.out.println(o1 == o3);

        System.out.println(Objects.hashCode(o3));
    }
}
