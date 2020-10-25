package guava;

import com.google.common.base.Stopwatch;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class StopwatchTest {
    public static void main(String[] args) {
        Stopwatch started = Stopwatch.createStarted();
        int j = 0;
        List list = Lists.newArrayList(1_000_000_000);
        for (int i = 0; i < 1_000_000_000; i++) {
            list.add(new Object());
        }
        System.out.println(j);
        System.out.println(list.size());
        long millse = started.elapsed(TimeUnit.MILLISECONDS);
        System.out.println(millse);
    }
}
