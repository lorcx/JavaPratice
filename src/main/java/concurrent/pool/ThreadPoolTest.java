package concurrent.pool;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.*;

/**
 * 文件匹配关键字搜索
 * @Author: lx
 * @Date: Created in 2018/3/20 0020
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter base directory (e.g. F:\\abc):");
        String directory = in.nextLine();
        System.out.println("Enter keyword(e.g. volatile):");
        String keyword = in.nextLine();

        long startTime = System.nanoTime();
        ExecutorService pool = Executors.newCachedThreadPool();
        MatcherCounter counter = new MatcherCounter(new File(directory), keyword, pool);
        Future<Integer> result = pool.submit(counter);

        try {
            System.out.println(result.get() + "matching files.");
        } catch (InterruptedException e) {
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        pool.shutdown();

        // 线程池生命周期最大尺寸
        int largestPoolSize = ((ThreadPoolExecutor)pool).getLargestPoolSize();
        long endTime = System.nanoTime();
        System.out.println("largest pool size=" + largestPoolSize + " cost: " + (endTime - startTime) / 1_000_000_000);
    }
}
