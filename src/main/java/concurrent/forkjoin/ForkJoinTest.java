package concurrent.forkjoin;

import java.util.concurrent.ForkJoinPool;

/**
 * @Author: lx
 * @Date: Created in 2018/3/20 0020
 */
public class ForkJoinTest {
    public static void main(String[] args) {
        final int SIZE = 100000000;
        double[] numbers = new double[SIZE];
        for (int i = 0; i < SIZE; i++){
            numbers[i] = Math.random();
        }
        Counter counter = new Counter(numbers, 0, numbers.length, t -> t > 0.5);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(counter);
        System.out.println(counter.join());
    }

}
