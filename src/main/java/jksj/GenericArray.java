package jksj;

import design_model.bridge.Source;

import java.time.temporal.ValueRange;
import java.util.Objects;

/**
 * @Author: lx
 * @Date: Created in 2019/11/13 0013
 */
public class GenericArray<T> {
    private T[] data;
    //元素个数
    private int size;

    //根据传入容量。构造array
    public GenericArray(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    public GenericArray() {
        this(10);
    }

    /**
     * 获取数组容量
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 获取数据元素个数
     *
     * @return
     */
    public int count() {
        return size;
    }

    /**
     * 判断数组是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 检查index是否合法
     *
     * @param index
     */
    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index不合法");
        }
    }

    /**
     * 在index位置，插入元素，时间复杂度O(m+n)
     * 队头插入，队尾元素被覆盖
     *
     * @param index
     * @param e
     */
    public void insert(int index, T e) {
        checkIndex(index);

        if (size == data.length) {
            resize(data.length * 2);
        }

        /**
         * 将元素向后移动
         *
         * 初始
         * [0, 1, 2, 3, 4, 5, x, x, x]
         *
         * insert index = 1
         *        index                  size-1   size
         * [0,    1,      2,      3,     4,       5,      x,      x,     x]
         */
        for (int i = size - 1; i > index; i--) {
            data[i + 1] = data[i];
        }

        data[index] = e;
        size++;
    }

    /**
     * 扩容方法，时间复杂度O(n)
     *
     * @param capacity
     */
    private void resize(int capacity) {
        T[] newData = (T[]) new Object[capacity];

        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }

        data = newData;
    }

    public void addFirst(T e) {
        insert(0, e);
    }

    public void addLast(T e) {
        //插入到末尾会触发扩容
        insert(size, e);
    }

    /**
     * 更新
     *
     * @param index
     * @param e
     */
    public void set(int index, T e) {
        checkIndex(index);
        data[index] = e;
    }

    public T get(int index) {
        checkIndex(index);
        return data[index];
    }

    public boolean contains(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获取元素对应下表位置，未找到返回-1
     *
     * @param e
     * @return
     */
    public int find(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 删除并返回删除元素
     *
     * @param index
     */
    public T remove(int index) {
        checkIndexForRemove(index);

        T ret = data[index];

        //向前移动
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;

        //缩容
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return ret;
    }

    public T removeFirst() {
        return remove(0);
    }

    public T removeLast() {
        return remove(size - 1);
    }

    public T removeElement(T e) {
        int index = find(e);
        if (index != -1) {
            return remove(index);
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Array size:").append(size).append(" capacity:").append(data.length);
        builder.append("[");
        for (int i = 0; i < size; i++) {
            builder.append(data[i]);
            if (i != size - 1) {
                builder.append(", ");
            }
        }
        builder.append("]");
        return builder.toString();
    }

    private void checkIndexForRemove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("删除位置不合法");
        }
    }

    public static void main(String[] args) {
        GenericArray<Integer> ga = new GenericArray<>();
        System.out.println(ga);
        System.out.println(ga.getCapacity());
        System.out.println(ga.count());

        ga.insert(0, 1);
        ga.insert(1, 2);
        ga.insert(2, 3);
        System.out.println(ga);

        ga.remove(0);
        System.out.println(ga);

        ga.remove(0);
        ga.remove(0);
        System.out.println(ga);

        for (int i = 0; i < 10; i++) {
            ga.insert(i, i + 1);
        }

        System.out.println(ga);


        ga = new GenericArray<>();
        for (int i = 0; i < 15; i++) {
            ga.insert(i, i + 1);
        }

        System.out.println(ga);
    }
}
