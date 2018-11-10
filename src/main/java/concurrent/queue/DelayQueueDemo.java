package concurrent.queue;

import java.util.concurrent.DelayQueue;

/**
 * @Author lx
 * @Date 2018/11/10 22:21
 */
public class DelayQueueDemo {
    DelayQueue<DelayItem> delayQueue = new DelayQueue<>();

    public static void main(String[] args) {
        System.out.println("delayedqueue test");

        DelayQueueDemo dqd = new DelayQueueDemo();
        dqd.produce();
        dqd.consumer();
    }

    /**
     * 消费队列
     */
    private void consumer() {
        new Thread(() -> {
            try {
                while (true) {
                    DelayItem item = delayQueue.take();
                    System.out.println("取出时间: " + System.currentTimeMillis() + " " + item);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    /**
     * 每隔100毫秒往队列里放入一个元素, 元素1s后取出
     */
    private void produce() {
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                delayQueue.offer(new DelayItem(10000, "test"));
            }
        }).start();

        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                System.out.println("队列个数：" + delayQueue.size());
            }
        }).start();
    }
}
