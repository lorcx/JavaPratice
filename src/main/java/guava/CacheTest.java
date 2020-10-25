package guava;

import com.google.common.cache.*;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CacheTest {
    public static void main(String[] args) throws ExecutionException {
        LoadingCache<Object, Object> build = CacheBuilder.newBuilder()
                //并发级别是指可以同时写缓存线程数
                .concurrencyLevel(10)
                //过期时间
                .expireAfterWrite(10, TimeUnit.MILLISECONDS)
                //初始容量
                .initialCapacity(10)
                //最大容量，超过之后按照LRU最近最少使用移除
                .maximumSize(500)
                .removalListener(new RemovalListener<Object, Object>() {
                    @Override
                    public void onRemoval(RemovalNotification<Object, Object> notification) {
                        System.out.println(notification.getKey() + " - " + notification.getValue());
                    }
                })
                .build(new CacheLoader<Object, Object>() {
                    @Override
                    public Object load(Object key) throws Exception {
                        return "hello" + key;
                    }
                });
        ;

        System.out.println(build.apply("aaa"));
        System.out.println(build.get("bbb"));
        System.out.println(build.get("bbb"));
        build.put("aaa", "ccc");
        System.out.println(build.get("aaa"));
        build.invalidateAll();
    }
}
