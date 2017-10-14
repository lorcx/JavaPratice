package review;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by lx on 2017/10/14.
 */
public class BubbleSorter implements Sorter {

    @Override
    public <T extends Comparable<T>> void sort(T[] list) {
        boolean swapped = true;
        for (int i = 1, len = list.length; i < len && swapped; i++) {
            swapped = false;
            for (int j = 0; j < len - i; j++) {
                if (list[j].compareTo(list[j + 1]) > 0) {
                    T temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    swapped = true;
                }
            }
        }
    }

    @Override
    public <T> void sort(T[] list, Comparator<T> comparator) {
        boolean swapped = true;
        for (int i = 1, len = list.length; i < len && swapped; i++) {
            swapped = false;
            for (int j = 0; j < len - i; j++) {
                if (comparator.compare(list[j], list[j + 1]) > 0) {
                    T temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    swapped = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] intArr = new Integer[]{1, 3, 4, 2, 7, 12, 5, 8, 921, 4, 123, 8};
        Sorter sorter = new BubbleSorter();
        sorter.sort(intArr);
        System.out.println(Arrays.toString(intArr));
    }
}
