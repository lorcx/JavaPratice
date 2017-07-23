package java8.chap6;

import java.util.function.Consumer;

/**
 *  1_000_000  java7 后新增特性 提高可读性
 *  duration 持续
 * Created by lx on 2016/12/18.
 */
public class CollectorHarness {
    public static void main(String[] args) {
        System.out.println("Partioning done in : "+ execute(PartitionPrimeNumbers::partitionPrimesWithCustomCollector) + " msecs");
    }

    private static long execute(Consumer<Integer> primePartitioner) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            primePartitioner.accept(1_000_000);
            long duration = (System.nanoTime() - start) / 1_000_000;
            if (duration < fastest) {
                fastest = duration;
            }
            System.out.println("done in " + duration);
        }
        return fastest;
    }
}
