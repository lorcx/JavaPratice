package jksj.part06;

import java.util.HashMap;
import java.util.Map;

/**
 * 使用数组实现lru缓存
 *  空间复杂度O(N)
 *  时间复杂度O(N)
 * @Author: lx
 * @Date: Created in 2019/11/18 0018
 */
public class LruBaseArray<T> {
    private static final int DEFAULT_CAPACITY = (1 << 3);
    private int capacity;
    /**
     * 当前存储的元素个数
     */
    private int count;
    private T[] value;
    private Map<T, Integer> holder;

    public LruBaseArray() {
        this(DEFAULT_CAPACITY);
    }

    public LruBaseArray(int capacity) {
        this.capacity = capacity;
        value = (T[]) new Object[capacity];
        count = 0;
        holder = new HashMap<>(capacity);
    }

    public boolean isFull() {
        return count == capacity;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isContain(T object) {
        return holder.containsKey(object);
    }

    public void offset(T object) {
        if (null == object) {
            throw new IllegalArgumentException("不支持null");
        }

        Integer index = holder.get(object);
        if (null == index) {
            if (isFull()) {
                removeAndCache(object);
            } else {
                cache(object, count);
            }
        } else {
            update(index);
        }
    }

    private void update(Integer index) {
        T target = value[index];
        rightShift(index);
        value[0] = target;
        holder.put(target, 0);
    }

    private void removeAndCache(T object) {
        //删除队尾
        rightShift(--count);
        //插入队头
        value[0] = object;
        holder.put(object, 0);
        count++;
    }

    /**
     * 缓存数据到头部，但先要右移
     *
     * @param object
     * @param end    在数组中的索引index
     */
    public void cache(T object, int end) {
        rightShift(end);
        //放到队列头部
        value[0] = object;
        holder.put(object, 0);
        count++;
    }

    /**
     * 将指定位置前的数据向后移动
     *
     * @param end
     */
    private void rightShift(int end) {
        for (int i = end - 1; i >= 0; i--) {
            value[i + 1] = value[i];
            holder.put(value[i], i + 1);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < value.length; i++) {
            builder.append(value[i]).append(" ");
        }
        return builder.toString() + "====" + holder;
    }

    static class TestLruBaseArray {
        public static void main(String[] args) {
            testDefaultConstructor();
            testSpecifiedConstructor();
        }

        private static void testSpecifiedConstructor() {
            System.out.println("有参测试");
            LruBaseArray<Integer> array = new LruBaseArray<>(4);
            array.offset(1);
            array.offset(2);
            array.offset(3);
            array.offset(4);
            System.out.println(array);
            array.offset(5);
            array.offset(6);
            System.out.println(array);
            array.offset(7);
            array.offset(8);
            System.out.println(array);
        }

        private static void testDefaultConstructor() {
            System.out.println("无参测试");
            LruBaseArray<Integer> array = new LruBaseArray<>();
            array.offset(1);
            array.offset(2);
            array.offset(3);
            array.offset(4);
            array.offset(5);
            array.offset(6);
            System.out.println(array);
            array.offset(7);
            array.offset(8);
            array.offset(9);
            System.out.println(array);
            array.offset(10);
            array.offset(11);
            System.out.println(array);
        }
    }
}
