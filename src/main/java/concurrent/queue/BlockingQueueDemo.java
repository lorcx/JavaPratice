package concurrent.queue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @Author: lx
 * @Date: Created in 2018/10/29 0029
 */
public class BlockingQueueDemo {
    public static void main(String[] args) {
        // 创建一个公平阻塞队列
        ArrayBlockingQueue abQueue = new ArrayBlockingQueue(1024, true);
        try {
            abQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
