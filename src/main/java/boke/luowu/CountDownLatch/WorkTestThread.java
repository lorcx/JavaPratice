package boke.luowu.CountDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * 测试线程
 * Created by Administrator on 2017/10/18 0018.
 */
public class WorkTestThread implements Runnable{
    private Work workder;
    private CountDownLatch latch;

    public WorkTestThread(Work workder, CountDownLatch latch) {
        this.workder = workder;
        this.latch = latch;
    }

    @Override
    public void run() {
        workder.doWork();
        latch.countDown();
    }
}
