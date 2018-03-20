package Thread;

/**
 * 一共2个线程 main主线程 和 子线程 交替执行
 *  在同一个时间点上只有一个线程执行
 *
 *  start是线程启动
 *  run方法是方法调用
 *
 *  如果用run启动那么执行顺序是一条
 *  run中的代码运行完，在运行main的下面
 *
 *  而start是告诉cpu准备完毕 不一定什么时候开始调用
 *  他是2条线执行
 * Created by lx on 2016/2/13.
 */
@SuppressWarnings("unused")
public class TestThread1 implements Runnable{
    public static void main(String[] args) {
        Thread t = new Thread(new TestThread1());
        t.start();
//        t.run(); ×
        for(int i = 0;i < 100;i++){
            System.out.println("main :" + i);
        }
    }

    public void run() {
        for(int i = 0;i < 100;i++){
            System.out.println("concurrent :" + i);
        }
    }
}
