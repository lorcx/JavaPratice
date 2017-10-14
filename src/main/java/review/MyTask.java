package review;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 使用callable实现多线程
 * Created by lx on 2017/10/13.
 */
public class MyTask implements Callable{
    private int upperBounds;// 上限

    public MyTask(int upperBounds) {
        this.upperBounds = upperBounds;
    }

    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 0; i < upperBounds; i++) {
            sum += i;
        }
        return sum;
    }
}

class TestCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Future<Integer>> list = new ArrayList<>();
        ExecutorService exec = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            list.add(exec.submit(new MyTask((int) (Math.random() * 100))));
        }

        int sum = 0;
        for (Future<Integer> f : list) {
            sum += f.get();
        }
        System.out.println(sum);
    }
}