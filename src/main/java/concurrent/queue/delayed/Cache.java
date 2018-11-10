package concurrent.queue.delayed;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @Author: lx
 * @Date: Created in 2018/10/29 0029
 */
public class Cache<K, V> {
    private Logger logger = Logger.getLogger(Cache.class.getName());

    private ConcurrentMap<K, V> cacheObjMap = new ConcurrentHashMap<>();

    private DelayQueue<DelayItem<Pair<K, V>>> q = new DelayQueue<>();

    private Thread daemonThread;


    public Cache() {
        daemonThread = new Thread(this::daemonCheck);
        daemonThread.setDaemon(true);
        daemonThread.setName("Cache Daemon");
        daemonThread.start();
    }

    private void daemonCheck() {
        if (logger.isLoggable(Level.INFO)) {
            logger.info("cache service started.");
        }

        for (;;) {
            try {
                DelayItem<Pair<K, V>> delayItem = q.take();
                System.out.println(delayItem);
                if (delayItem != null) {
                    // 超市处理
                    Pair<K, V> pair = delayItem.getItem();
                    cacheObjMap.remove(pair.key, pair.value);
                }
            } catch (InterruptedException e) {
                if (logger.isLoggable(Level.SEVERE)) {
                    logger.log(Level.SEVERE, e.getMessage(), e);
                }
                break;
            }
        }

        if (logger.isLoggable(Level.INFO)) {
            logger.info("cache service stoped.");
        }
    }

     public void put(K key, V value, long time, TimeUnit unit) {
        // 放入到缓存中
        V oldValue = cacheObjMap.put(key, value);
        if (oldValue != null) {
            // 更新值就删掉队列中的数据
            q.remove(key);
        }

        // 将原来的时间转换为纳秒
        long nanoTime = TimeUnit.NANOSECONDS.convert(time, unit);
        // 放入延迟队列
        q.put(new DelayItem<>(new Pair<>(key, value), nanoTime));
     }

     public V get(K key) {
        return cacheObjMap.get(key);
     }

    public static void main(String[] args) {
        Cache<Integer, String> cache = new Cache<>();
        cache.put(1, "sss", 3, TimeUnit.SECONDS);

        /*try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        String s = cache.get(1);
        System.out.println(s);

         s = cache.get(1);
        System.out.println(s);

        cache.put(1, "bbb", 3, TimeUnit.SECONDS);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //s = cache.get(1);
        //System.out.println(s);
    }
}

