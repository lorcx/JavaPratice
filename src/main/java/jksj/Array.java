package jksj;

/**
 * 数组操作，随机访问操作
 *
 * @Author: lx
 * @Date: Created in 2019/11/12 0012
 */
public class Array {
    //数据存储
    private int[] data;
    //数组长度
    private int len;
    //当前存储元素个数
    private int count;

    public Array(int capacity) {
        data = new int[capacity];
        len = capacity;
        count = 0;
    }

    public void printAll() {
        for (int i = 0; i < count; ++i) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public boolean insert(int index, int value) {
        if (index < 0 || index > len) {
            return false;
        }

        //数组满了
        if (count == len) {
            System.out.println("数组已满");
            return false;
        }

        //将index位置后边的数据向后移动一位
        for (int i = count; i > index; --i) {
            data[i] = data[i - 1];
        }

        //放入数据
        data[index] = value;
        ++count;
        return true;
    }

    public boolean delete(int index) {
        if (index < 0 || index >= count) {
            return false;
        }

        for (int i = index + 1; i < count; ++i) {
            data[i - 1] = data[i];
        }

        --count;
        return true;

    }

    public static void main(String[] args) {
        Array array = new Array(5);
        array.printAll();
        array.insert(0, 3);
        array.insert(0, 4);
        array.insert(1, 5);
        array.insert(3, 9);
        array.insert(3, 10);
        //array.insert(3, 11);
        array.printAll();
    }

}
