package se.reference;

/**
 * 强引用
 * 无论内存是否够用都不会回收
 * @Author lx
 * @Date 2019/2/6 20:09
 */
public class StrongReferenceTest {
    public static int M = 1024 * 1024;

    public static void printMemeory(String tag) {
        Runtime runtime = Runtime.getRuntime();
        int M = StrongReferenceTest.M;
        System.out.println("\n" + tag + ":");
        System.out.println(runtime.freeMemory()/M + "M(free)" + runtime.totalMemory()/M + "M(total)");
    }

    public static void main(String[] args) {
        printMemeory("1.原可用内存");
        byte[] strongReference = new byte[10 * M];
        printMemeory("2.实例化10M的数组，并建立强引用");
        System.out.println("strongreference:" + strongReference);

        System.gc();
        printMemeory("3.GC后");
        System.out.println("strongreference:" + strongReference);

        strongReference = null;
        printMemeory("4.强引用断开后");
        System.out.println("strongReference: " + strongReference);

        System.gc();
        printMemeory("5.gc后");
        System.out.println("strongReference: " + strongReference);

    }
}
