package Thread;

/**
 * yield 让出一些cpu资源 相当于切换到别的线程
 * Created by lx on 2016/2/13.
 */
@SuppressWarnings("unused")
public class TestThread4 {
    public static void main(String[] args) {
        MyThread4 m1 = new MyThread4();
        Thread t1 = new Thread(m1);
        t1.setName("t1");
        Thread t2 = new Thread(m1);
        t2.setName("t2");

        t1.start();
        t2.start();
    }
}

class MyThread4 implements Runnable{

    public void run() {
        for(int i = 0;i < 100;i++){
            System.out.println(Thread.currentThread().getName() + ":" + i);
            if(i % 10 == 0){
                Thread.yield();
            }
        }
    }
}