package leeatcode;

import java.util.Arrays;

/**
 * @Author lx
 * @Date 2019/3/16 20:56
 */
public class ArrayDuplications {
    public static void main(String[] args) {
        // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
        int[] nums = {1, 1, 2, 2, 3, 3, 4};
        //int len = removeDuplicates(nums);
        //System.out.println(len);
        // 在函数里修改输入数组对于调用者是可见的。
        // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。

        //System.out.println(Arrays.toString(nums));
        //
        //
        //int[] ints = ifRepeat(nums);
        //System.out.println(Arrays.toString(ints));
        //
        int[] i = removeDuplicates2(nums);
        System.out.println(Arrays.toString(i));

        //int[] ints = ifRepeat(nums);
        //System.out.println(Arrays.toString(ints));

    }

    /**
     * 数组去重
     * @param nums
     * @return
     */
    public static int[] removeDuplicates2(int[] nums) {
        if (nums.length == 0) {
            return new int[0];
        }

        int[] tmp = new int[nums.length];
        int t = 0;

        for (int i = 0, len = nums.length; i < len; i++) {
            boolean findRepeat = true;

            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    findRepeat = false;
                    break;
                }
            }

            if (findRepeat) {
                tmp[t] = nums[i];
                t++;
            }
        }
        System.out.println(Arrays.toString(tmp));
        int[] newArr = new int[t];
        System.arraycopy(tmp, 0, newArr, 0, t);
        return newArr;
    }

    /**
     * 我的题解
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int number = 0;
        for (int i = 1, len = nums.length; i < len; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[++number] = nums[i];
            }
        }
        return ++number;
    }

    /**
     * 官方题解
     * @param nums
     * @return
     */
    public static int removeDuplicates3(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }


    //方法一：需要传入一个Object数组，然后返回去重后的数组
    /*public static int[] ifRepeat(int[] arr) {
        //用来记录去除重复之后的数组长度和给临时数组作为下标索引
        int t = 0;
        //临时数组
        int[] tempArr = new int[arr.length];
        //遍历原数组
        for (int i = 0; i < arr.length; i++) {
            //声明一个标记，并每次重置
            boolean isTrue = true;
            //内层循环将原数组的元素逐个对比
            for (int j = i + 1; j < arr.length; j++) {
                //如果发现有重复元素，改变标记状态并结束当次内层循环
                if (arr[i] == arr[j]) {
                    isTrue = false;
                    break;
                }
            }
            //判断标记是否被改变，如果没被改变就是没有重复元素
            if (isTrue) {
                //没有元素就将原数组的元素赋给临时数组
                tempArr[t] = arr[i];
                //走到这里证明当前元素没有重复，那么记录自增
                t++;
            }
        }
        //声明需要返回的数组，这个才是去重后的数组
        int[] newArr = new int[t];
        //用arraycopy方法将刚才去重的数组拷贝到新数组并返回
        System.arraycopy(tempArr, 0, newArr, 0, t);
        return newArr;
    }*/
}
