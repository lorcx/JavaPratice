package concurrent.queue.delayed;

/**
 * @Author: lx
 * @Date: Created in 2018/10/29 0029
 */
public class Pair<K, V> {
    K key;
    V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
