package java8.chap6;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

import static java.util.stream.Collector.Characteristics.CONCURRENT;
import static java.util.stream.Collector.Characteristics.IDENTITY_FINISH;

/**
 * Created by lx on 2016/12/18.
 */

public class ToListCollector<T> implements Collector<T, List<T>, List<T>> {

    // supplier 供应者
    @Override
    public Supplier<List<T>> supplier() {
        return () -> new ArrayList<T>();
    }

    //accumulator 积聚者
    @Override
    public BiConsumer<List<T>, T> accumulator() {
        return (list, item) -> list.add(item);
    }

    //finisher 整理者
    @Override
    public Function<List<T>, List<T>> finisher() {
        return i -> i;
    }

    // combiner 组合者
    @Override
    public BinaryOperator<List<T>> combiner() {
        return (list1, list2) -> {
            list1.addAll(list2);
            return list1;
        };
    }

    //characteristics 特性
    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(IDENTITY_FINISH, CONCURRENT));
    }
}