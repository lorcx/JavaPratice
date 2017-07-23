package util;

import java.util.Random;

/**
 * 随机数生成器
 * Created by lx on 2016/11/13.
 */
public class RandomGenerate {
    public static Random rand = new Random();

    /**
     * 生成最小-最大之间的数据
     * @param min
     * @param max
     * @return
     */
    public static int next(int min, int max) {
        return rand.nextInt((max - min) + 1) + min;
    }

    public static void main(String[] args) {
        for (;;) {
            System.out.println(RandomGenerate.next(5, 10));
        }
    }

}
