package redis;

import redis.clients.jedis.Jedis;
import java.util.HashMap;
import java.util.Map;

/**
 * redis做分布式锁
 * @Author: lx
 * @Date: Created in 2018/10/22 0022
 */
public class RedisWithReentrantLock {
    /**
     * String redis key
     * Integer 锁次数
     */
    private ThreadLocal<Map<String, Integer>> lockers = new ThreadLocal<>();

    private Jedis jedis;

    public RedisWithReentrantLock(Jedis jedis) {
        this.jedis = jedis;
    }

    private boolean lockThis(String key) {
        return jedis.set(key, "true", "nx", "ex", 5L) != null;
    }

    private void unlockThis(String key) {
        jedis.del(key);
    }

    private Map<String, Integer> currentLockers() {
        Map<String, Integer> refs = lockers.get();
        if (refs != null) {
            return refs;
        }
        lockers.set(new HashMap<>());
        return lockers.get();
    }

    public boolean lock(String key) {
        Map<String, Integer> refs = currentLockers();
        Integer refCnt = refs.get(key);
        if (refCnt != null) {
            refs.put(key, refCnt++);
            return true;
        }

        // 第一次锁初始化
        boolean ok = this.lockThis(key);
        if (!ok) {
            return false;
        }
        refs.put(key, 1);
        return true;
    }

    public boolean unlock(String key) {
        Map<String, Integer> refs = currentLockers();
        Integer refCnt = refs.get(key);
        if (refCnt == null) {
            return false;
        }

        refCnt -= 1;
        if (refCnt > 0) {
            refs.put(key, refCnt);
        } else {
            refs.remove(key);
            this.unlockThis(key);
        }
        return true;
    }

    public static void main(String[] args) {
        Jedis jedis = new Jedis();
        RedisWithReentrantLock redis = new RedisWithReentrantLock(jedis);
        System.out.println(redis.lock("codeHole"));
        System.out.println(redis.lock("codeHole"));
        System.out.println(redis.unlock("codeHole"));
        System.out.println(redis.unlock("codeHole"));
    }
}
