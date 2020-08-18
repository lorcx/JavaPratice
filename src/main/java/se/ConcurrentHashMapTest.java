package se;


import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

/**
 * @Author: lx
 * @Date: Created in 2019/6/9 0009
 */
public class ConcurrentHashMapTest {
    static ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

    public static void main(String[] args) throws InterruptedException {
        f1();
        //f2();
    }

    /**
     * for遍历时能够看到put remove等操作造成的结果
     * @throws InterruptedException
     */
    private static void f2() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            map.put(i + "", i);
        }

        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            map.put("100", 100);
            System.out.println("t1 add 100");
        });
        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t2 foreach");
            for (Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator(); iterator.hasNext(); ) {
                Map.Entry<String, Integer> entry = iterator.next();
                System.out.println(entry.getKey() + "=" + entry.getValue());
            }

        });

        t1.start();
        t2.start();
        Thread.sleep(3000);

        System.out.println("----------------------------------");
        map.forEach((k, v) -> System.out.println(k + "=" + v));
    }

    public static void f1() throws InterruptedException {
        map.put("sum", 0);

        CountDownLatch latch = new CountDownLatch(1);
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100_0000; i++) {
                synchronized (map) {
                    int sum = map.get("sum");
                //    map.put("sum", ++sum);
                    map.putIfAbsent("sum", ++sum);

                }
            }
            latch.countDown();
        });


        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100_0000; i++) {
                synchronized (map) {
                    int sum = map.get("sum");
                    map.put("sum", ++sum);
                }
            }
            latch.countDown();
        });

        t1.start();
        //t2.start();
        latch.await();

        System.out.println(map.get("sum"));
    }
}
