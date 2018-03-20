package Thread;

/**
 *  同步理解
 *  同一个对象有2个同步方法 运行一个方法的时候就会获得这个对象的锁，其他的同步方法则不能运行，需要等锁释放。
 *  sleep后切换线程
 *
 *  1.m2是同步的：
 *    main线程启动
 *    start() 线程准备就绪 因为 main线程比子线程速度快（方法调用t.m2()）
 *    执行m2 睡修改值 ,main线程锁住了对象
 *    m2执行完毕 执行子线程 m1()
 *    m1修改 后睡眠 切换到main线程
 *    main sout 1000
 *    m1 sout 1000结束 释放锁
 *    (线程交替执行 利用了锁 让m1等待)
 *
 *  2. m2不是同步的
 *  main线程启动
 *  m1锁住修改睡
 *  执行m2 睡2.5 修改
 *  main 输出 2000
 *  5s后m1 输出 2000
 *
 * Created by dell on 2016/2/14.
 */
public class Tt implements Runnable{
    static int b = 0;

    public synchronized void m1(){
        b = 1000;
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {

        }
        System.out.println("b = "+ b);
    }

//    public synchronized void m2(){
    public void m2(){
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {

        }
        b = 2000;
    }

    public void run() {
        m1();
    }

    public static void main(String[] args) {
        Tt t = new Tt();
        Thread thread = new Thread(t);
        thread.start();
        t.m2();
        System.out.println(b);
    }

}
