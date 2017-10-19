package review;

import java.util.Comparator;

/**
 * Created by lx on 2017/10/14.
 */
public interface Sorter {
    /**
     * 排序
     * @param list 待排序的数组
     * @param <T>
     */
    public <T extends Comparable<T>> void sort(T[] list);

    /**
     * 排序
     * @param list 待排序的数组
     * @param comparator 比较器
     * @param <T>
     */
    public <T> void sort(T[] list, Comparator<T> comparator);
}
