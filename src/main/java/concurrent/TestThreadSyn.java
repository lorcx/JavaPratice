package Thread;

/**
 * 线程同步
 * Created by dell on 2016/2/14.
 */
@SuppressWarnings("unused")
public class TestThreadSyn implements Runnable {
    private Timer timer = new Timer();

    public void run() {
        timer.add(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        TestThreadSyn tts = new TestThreadSyn();
        Thread t1 = new Thread(tts);
        Thread t2 = new Thread(tts);
        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        t2.start();
    }
}

@SuppressWarnings("unused")
class Timer{
    private static int num = 0;//静态的 每次都会递增 作为计数器
    public void add(String name){
        synchronized (this){// 锁定当前对象  如果不锁住  就会第一个++睡眠后  第二个也++ 睡眠 然后输出第一个
            num++;
            try {
                Thread.sleep(1);  //原因在于num和输出的这两句应该是原子性的不可再分
            } catch (InterruptedException e) {}
            System.out.println(name + "你是第" + num + "个");
        }
    }
}
