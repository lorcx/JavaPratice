package se;

import java.util.function.Supplier;

/**
 * @Author lx
 * @Date 2019/1/28 21:29
 */
public class TestClass2 {
    public static void main(String[] args) throws InterruptedException {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 200;
        Integer e = 300;
        Integer f = 500;
        Integer g = 3;
        Long h = 3L;

        System.out.println((a + b) == 3);
        System.out.println((a + b) == c);
        System.out.println((d + e) == f);
        System.out.println(c == g);
        System.out.println((a + b) == h);
        System.out.println(h.equals(a + b));
        System.out.println(c.equals(a + b));
        System.out.println(f.equals(d + e));


        //List<Integer> list = Arrays.asList(1, 2, 3, 4);
        Thread.sleep(100000000);

        //List<Integer> collect = list.stream().sorted().collect(Collectors.toList());
        //System.out.println(collect);

        Supplier<TestClass2> supplier = () -> new TestClass2();
    }
}
