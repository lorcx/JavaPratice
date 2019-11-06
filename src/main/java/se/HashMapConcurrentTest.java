package se;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @Author: lx
 * @Date: Created in 2019/6/5 0005
 */
public class HashMapConcurrentTest {
    public static void main(String[] args) throws InterruptedException {
       /* final Map<String, String> map = new HashMap<>(2);
        Thread t = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                new Thread(() -> {
                    map.put(UUID.randomUUID().toString(), "");
                }, "f" + i).start();
            }
        });
        t.start();
        t.join();*/
        System.out.println(2 << 1);

        System.out.println(Integer.parseInt("0001111", 2) & 15);


        System.out.println(Integer.parseInt("0011111", 2) & 15);


        System.out.println(Integer.parseInt("0111111", 2) & 15);

        System.out.println(Integer.parseInt("1111111", 2) & 15);

        System.out.println(Integer.parseInt("0001111", 2));


        System.out.println(Integer.parseInt("0011111", 2));


        System.out.println(Integer.parseInt("0111111", 2));

        System.out.println(Integer.parseInt("1111111", 2));

    }

}
