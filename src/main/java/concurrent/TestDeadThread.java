package Thread;

/**
 * 死锁
 * Created by dell on 2016/2/14.
 */
@SuppressWarnings("unused")
public class TestDeadThread implements Runnable{
    private int flag = 1;
    static Object o1 = new Object(); //static是死锁的一个关键点
    static Object o2 = new Object();

    public void run() {
        if(flag == 1) {
            synchronized (o1){//它拿到o1锁和o2锁就能执行完毕
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {

                }
                synchronized (o2){
                    System.out.println("o2");
                }
            }
        }else{
            synchronized (o2){//它拿到o2锁和o1锁就能执行完毕
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {

                }
                synchronized (o1){
                    System.out.println("o1");
                }
            }
        }
    }

    public static void main(String[] args) {
        TestDeadThread tt = new TestDeadThread();
        TestDeadThread tt1 = new TestDeadThread();//因为static 所以不管new多少次，只初始化一次 这两个对象的static都公用一个资源
        tt.flag = 0;
        tt1.flag = 1;
        Thread t1 = new Thread(tt);
        Thread t2 = new Thread(tt1);
        t1.start();
        t2.start();
    }
}

