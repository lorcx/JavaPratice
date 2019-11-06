package concurrent.pattern.masterWorker;

/**
 * @Author lx
 * @Date 2019/2/23 23:30
 */
public class MasterWorkTest {
    public static void main(String[] args) throws InterruptedException {
        Master master = new Master(new Worker(), 10);

        long start = System.currentTimeMillis();

        Task t;
        for (int i = 0; i < 100; i++) {
            t = new Task();
            t.setId(i);
            t.setName("任务" + i);
            t.setPrice(i);
            master.submit(t);
        }

        master.execute();

        // 等待执行完毕
        while (!master.isComplete()) {
            Thread.sleep(10);
        }

        Object processResult = master.getResult();
        System.out.println("处理完毕结果：" + processResult + " 处理时间"+ (System.currentTimeMillis() - start));
    }
}
