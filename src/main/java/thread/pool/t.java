package thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class t {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        ExecutorService exec1 = Executors.newFixedThreadPool(2);
        ExecutorService exec2 = Executors.newScheduledThreadPool(2);
        ExecutorService exec3 = Executors.newSingleThreadScheduledExecutor();
    }
}
