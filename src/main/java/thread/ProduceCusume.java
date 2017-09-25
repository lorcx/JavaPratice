package Thread;

/**
 * 生产者消费者吃馒头
 * Created by dell on 2016/2/15.
 */
@SuppressWarnings("unused")
public class ProduceCusume {
    public static void main(String[] args) {
        LanZi l = new LanZi();
        Produce p = new Produce(l);
        Cusume c = new Cusume(l);
        new Thread(p).start();
        new Thread(c).start();
    }
}

/**
 * 馒头
 */
@SuppressWarnings("unused")
class ManTou{
    private int id;

    public ManTou(int id) {
        this.id = id;
    }

    public String toString() {
        return "馒头 ：" + id;
    }
}

/**
 * 篮子用来放置馒头
 * 利用栈存放
 * 此类是共享的资源需要同步
 */
@SuppressWarnings("unused")
class LanZi{
    private ManTou[] mt = new ManTou[6];
    private int index;//栈的指针

    /**
     * 放馒头
     */
    public synchronized void push(ManTou m){
        while(index == mt.length){//生产满了 用while不用if是因为如果抛出异常 他会继续往下走 而while会再次判断
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notify();//其他线程唤醒
        mt[index] = m;
        index++;
        System.out.println("生产了 " + m );
    }

    /**
     * 取馒头
     * @return
     */
    public synchronized ManTou pop(){
        while(index == 0){//消费不够了 用while不用if是因为如果抛出异常 他会继续往下走 而while会再次判断
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notify();//其他线程唤醒
        index--;
        System.out.println("消费了 " + mt[index]);
        return mt[index];
    }

}

/**
 * 生产者
 */
@SuppressWarnings("unused")
class Produce implements Runnable{
    private LanZi lz = null;

    public Produce(LanZi lz) {
        this.lz = lz;//要让生产者知道馒头放到那个篮子里
    }

    public void run() {
        for (int i = 0;i < 20;i++){//最多生产20个
            lz.push(new ManTou(i));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 * 消费者
 */
@SuppressWarnings("unused")
class Cusume implements Runnable{
    private LanZi lz = null;

    public Cusume(LanZi lz) {
        this.lz = lz;//要让生产者知道馒头放到那个篮子里
    }

    public void run() {
        for (int i = 0;i < 20;i++){//最多消费20个
            ManTou m = lz.pop();
            System.out.println(m);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}