package se.reference;

import java.lang.ref.SoftReference;

/**
 * 软引用
 * 只有内存不足gc才会回收
 *
 * -Xms20m -Xmx20m
 * @Author lx
 * @Date 2019/2/6 20:09
 */
public class SoftReferenceTest {
    public static int M = 1024 * 1024;

    public static void printMemeory(String tag) {
        Runtime runtime = Runtime.getRuntime();
        int M = SoftReferenceTest.M;
        System.out.println("\n" + tag + ":");
        System.out.println(runtime.freeMemory()/M + "M(free)" + runtime.totalMemory()/M + "M(total)");
    }

    public static void main(String[] args) {
        printMemeory("1.原可用内存");
        SoftReference<Object> softReference = new SoftReference<>(new byte[10 * M]);
        printMemeory("2.实例化10M的数组，并建立软引用");
        System.out.println("softReference:" + softReference.get());

        System.gc();
        printMemeory("3.GC后");
        System.out.println("softReference:" + softReference.get());


        SoftReference<Object> softReference2 = new SoftReference<>(new byte[10 * M]);
        printMemeory("4.实例化10M的数组，并建立软引用");
        System.out.println("softReference:" + softReference.get());
        System.out.println("softReference:" + softReference2.get());
    }
}
