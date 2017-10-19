package boke.luowu.CountDownLatch;

/**
 * 工人类
 * Created by Administrator on 2017/10/18 0018.
 */
public class Work {
    private String name;// 名称
    private long workDuration; // 持续时间

    public Work(String name, long workDuration) {
        this.name = name;
        this.workDuration = workDuration;
    }

    /**
     * 完成工作
     */
    public void doWork() {
        System.out.println(name + "begins to work....");
        try {
            Thread.sleep(workDuration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + "has finished the job....");
    }
}
