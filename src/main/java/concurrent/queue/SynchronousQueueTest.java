package concurrent.queue;

import java.util.concurrent.SynchronousQueue;

/**
 * @Author lx
 * @Date 2019/2/23 20:07
 */
public class SynchronousQueueTest {

    /**
     * 必须有消费者才能使用
     * @param args
     */
    public static void main(String[] args) {
        SynchronousQueue<String> q = new SynchronousQueue<>();

        Thread t2 = new Thread(() -> {
            try {
                String s = q.take();
                System.out.println(s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t2.start();

        Thread t1 = new Thread(() -> {
            boolean abc = q.add("abc");
        });

        t1.start();
    }
}
