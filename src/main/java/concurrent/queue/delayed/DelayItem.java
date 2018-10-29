package concurrent.queue.delayed;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Author: lx
 * @Date: Created in 2018/10/29 0029
 */
public class DelayItem<T> implements Delayed {

    /**
     * 初始时间
     */
    private static final long NANO_ORIGIN = System.nanoTime();

    /**
     * 返回当前时间对于起源的偏移量
     * @return
     */
    final static long now() {
        return System.nanoTime() - NANO_ORIGIN;
    }


    private static final AtomicLong sequencer = new AtomicLong(0);

    private final long sequencerNumber;

    /**
     * 每个缓存数据的失效时间
     */
    private final long time;

    /**
     * 缓存数据对象
     */
    private final T item;


    public DelayItem(T item, long timeOut) {
        this.time = now() + timeOut;
        this.item = item;
        this.sequencerNumber = sequencer.getAndIncrement();
    }

    public T getItem() {
        return item;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        long d = unit.convert(time - now(), TimeUnit.NANOSECONDS);
        return d;
    }

    @Override
    public int compareTo(Delayed o) {
        if (o == null) {
            return 0;
        }

        if (o instanceof DelayItem) {
            DelayItem item = (DelayItem) o;
            long diff = time - item.time;
            if (diff < 0) {
                return -1;
            } else if (diff > 0) {
                return 1;
            } else if (sequencerNumber < item.sequencerNumber) {
                return -1;
            } else {
                return 1;
            }
        }

        long d = getDelay(TimeUnit.NANOSECONDS) - o.getDelay(TimeUnit.NANOSECONDS);
        return d == 0 ? 0 : d > 0 ? 1 : -1;
    }
}
