package se;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lx
 * @Date: Created in 2019/5/16 0016
 */
public class TestMemory {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        printMemoryUsage(runtime);

        List<String> list = insertString();
        System.out.println(list.size());

        printMemoryUsage(runtime);

        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static List<String> insertString() {
        int initialCapacity = 3_000_000;
        List<String> list = new ArrayList<>(initialCapacity);
        for (int i = 0; i < initialCapacity; i++) {
            list.add("\"2017040921001004840298578762\t\"\t\"20170409112250200002\t\"\t退款\t苹果手机\t2017/4/9 11:24\t2017/4/9 11:38\t\"1111\t\"\t\"1111\t\"\t123456\tCN10000000001\t*霜(182****2378)\t-0.01\t-0.01\t0\t0\t0\t0\t0\t\t0\t0\t\"20170409113651430005\t\"\t0\t-0.01\t16433178953\t条码支付\t\n");
        }
        return list;
    }

    private static void printMemoryUsage(Runtime runtime) {
        System.out.println("free:" + runtime.freeMemory() / 1024 / 1024 + "Mb");
        System.out.println("max:" + runtime.maxMemory() / 1024 / 1024 + "Mb");
        System.out.println("total:" + runtime.totalMemory() / 1024 / 1024 + "Mb");
        System.out.println();
    }
}
