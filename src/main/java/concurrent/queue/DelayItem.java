package concurrent.queue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @Author lx
 * @Date 2018/11/10 22:22
 */
public class DelayItem implements Delayed {
    // 延期时间
    private final long delayd;
    // 创建时间
    private final long created;
    // 失效时间
    private final long exipre;

    private String msg;

    public DelayItem(long delayd, String msg) {
        this.delayd = delayd;
        this.exipre =  System.currentTimeMillis() + delayd;
        this.created = System.currentTimeMillis();
        this.msg = msg;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(exipre - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        return (int) (this.getDelay(TimeUnit.MILLISECONDS) - o.getDelay(TimeUnit.MILLISECONDS));
    }

    @Override
    public String toString() {
        return "DelayItem{" +
                "delayd=" + delayd +
                ", created=" + created +
                ", exipre=" + exipre +
                '}';
    }
}
