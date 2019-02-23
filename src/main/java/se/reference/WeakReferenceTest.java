package se.reference;

import java.lang.ref.WeakReference;

/**
 * 弱引用
 * 无论内存是否充足gc都会回收
 * @Author lx
 * @Date 2019/2/6 20:09
 */
public class WeakReferenceTest {
    public static int M = 1024 * 1024;

    public static void printMemeory(String tag) {
        Runtime runtime = Runtime.getRuntime();
        int M = WeakReferenceTest.M;
        System.out.println("\n" + tag + ":");
        System.out.println(runtime.freeMemory()/M + "M(free)" + runtime.totalMemory()/M + "M(total)");
    }

    public static void main(String[] args) {
        printMemeory("1.原可用内存");
        WeakReference<Object> weakReference = new WeakReference<>(new byte[10 * M]);
        printMemeory("2.实例化10M的数组，并建立强引用");
        System.out.println("weakReference:" + weakReference);

        System.gc();
        printMemeory("3.GC后");
        System.out.println("weakReference:" + weakReference);
    }
}
