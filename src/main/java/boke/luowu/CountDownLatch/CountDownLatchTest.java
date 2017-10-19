package boke.luowu.CountDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch 使用
 * Created by Administrator on 2017/10/18 0018.
 */
public class CountDownLatchTest {
    private static final int MAX_WORK_DURATION = 5000;// 最大工作时间
    private static final int MIN_WORK_DURATION = 1000;// 最小工作时间

    private static long getRandomWorkDuration(long min, long max) {
        long time = (long) (Math.random() * (max - min)) + min;
        System.out.println(time);
        return time;
    }

    public static void main(String[] args) {
        CountDownLatch cdLatch = new CountDownLatch(2);
        Work work1 = new Work("lixin", getRandomWorkDuration(MIN_WORK_DURATION, MAX_WORK_DURATION));
        Work work2 = new Work("jinnvshi", getRandomWorkDuration(MIN_WORK_DURATION, MAX_WORK_DURATION));
        new Thread(new WorkTestThread(work1, cdLatch)).start();
        new Thread(new WorkTestThread(work2, cdLatch)).start();

        try {
            cdLatch.await();
            System.out.println("All jobs been finished!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
