package review;

import java.util.Comparator;

/**
 * Created by lx on 2017/10/14.
 */
public class BinarySearch {
    /**
     * 循环二分查找法
     *
     * @param list 要查找的数组
     * @param key  要查找的值
     * @param comp 排序规则
     * @param <T>
     * @return
     */
    public static <T> int search(T[] list, T key, Comparator comp) {
        int low = 0;
        int high = list.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int n = comp.compare(list[mid], key);
            if (n > 0) {
                high = mid - 1;
            } else if (n < 0) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Integer[] inArr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int n = search(inArr, 10, (o1, o2) -> ((int) o1) - ((int) o2));
        System.out.println(n);
    }
}
