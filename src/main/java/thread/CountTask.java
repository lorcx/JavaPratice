package Thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * fork 分而治之
 * Created by lx on 2017/5/6.
 */
public class CountTask extends RecursiveTask<Long>{
    // THRESHOLD入口
    private static final int THRESHOLD = 10000;
    private long start;
    private long end;

    public CountTask(long start, long end) {
        this.start = start;
        this.end = end;
    }

    /**
     * 超过规模就分解成100小任务
     *
     * 5000 分解
     * for 100 个任务 每个50
     * 0 -> 50 51 -> 100 .......
     * @return
     */
    @Override
    protected Long compute() {
        long sum = 0;
        // (如果需要求和的总数大于任务的规模)
        boolean canComplate = (end - start) < THRESHOLD;
        if (canComplate) {
            // 注意要=
            for (long i = start; i <= end; i++) {
                sum += i;
            }
        } else {
            // 分成100个小任务
            long step = (start + end) / 100;
            List<CountTask> subTasks = new ArrayList<>();
            long pos = start;
            for (int i = 0; i < 100; i++) {
                long lastOne = pos + step;
                if (lastOne > end) {
                    lastOne = end;
                }
                CountTask subTask = new CountTask(pos, lastOne);
                pos += step + 1;
                subTasks.add(subTask);
                // 异步提交子任务
                subTask.fork();
            }

            for (CountTask t : subTasks) {
                sum += t.join();
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CountTask task = new CountTask(0, 200000L);
        ForkJoinTask<Long> result = forkJoinPool.submit(task);
        try {
            long res = result.get();
            System.out.println("sum= " + res);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
