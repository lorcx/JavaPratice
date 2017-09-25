package Thread;

/**
 * Created by lx on 2016/2/13.
 */
@SuppressWarnings("unused")
public class TestThread3 {
    public static void main(String[] args) {
        MyThread2 m = new MyThread2();
        Thread t = new Thread(m);
        t.setName("子线程");
        t.start();

        try {
            t.join(); //合并线程  等待t这个线程执行完 才执行 别的
        } catch (InterruptedException e) {

        }

        for(int i = 0;i < 10;i++){
            System.out.println("主线程");
        }

    }
}

class MyThread2 implements Runnable{

    public void run() {
        for(int i = 0;i < 10;i++){
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
