package Thread;

import java.util.Date;

/**
 * Created by lx on 2016/2/13.
 */
@SuppressWarnings("unused")
public class TestThread2 {
    public static void main(String[] args) {
        MyThread m = new MyThread();
        Thread t = new Thread(m);
//        MyThread t = new MyThread();
        t.start();
        try {
            t.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        t.interrupt();//中断改线程
        m.shutdown(); //中断线程  比上变得好  上边太粗暴
    }
}

@SuppressWarnings("unused")
//class MyThread extends thread.Thread{
class MyThread implements Runnable{
    boolean flag = true;
    public void run() {
        while(flag){
            System.out.println(new Date() + "");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("中断");
                return;
            }
        }
    }

    /**
     * 中短线程
     */
    public void shutdown(){
        flag = false;
    }

}