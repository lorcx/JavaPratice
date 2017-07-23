package util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Created by lx on 2016/11/13.
 */
public class NumberCommon {
    static DecimalFormat df = new DecimalFormat("######0.00");

    /**
     * 递归判断一个数是2的多少次方
     * @param n
     * @return
     */
    public static int log2Recu(int n) {
        if (n == 1) {
            return 0;
        } else {
            return 1 + log2Recu(n >> 1);
        }
    }

    /**
     * 非递归判断一个数是不是2的幂次方
     * @return
     */
    public static int log2(int n) {
        int i = 0;
        while (n > 1) {
            n = n >> 1;
            i++;
        }
        return i;
    }

    /**
     * 判断一个数是否为2的幂次方
     * 将2的幂次方写成二进制形式后，很容易就会发现有一个特点：
     * 二进制中只有一个1，并且1后面跟了n个0； 因此问题可以转化为判断1后面是否跟了n个0就可以了。
     * 因为2的N次方换算是二进制为10……0这样的形式(0除外)。与上自己-1的位数，
     * 这们得到结果为0。例如。8的二进制为1000；8-1=7，7的二进制为111。两者相与的结果为0。计算如下：
     * 1000
     * & 0111
     * -------
     * 000
     * @return
     */
    public static boolean isPower2(int n) {
        //java源码
//        return (n & -n) == n;
        return (n & n - 1) == 0;
    }



    /**
     * 返回一个数的2的幂次方
     * @param n
     * @return
     */
    public static int getPower2(int n) {
        int re = 0;
        if (isPower2(n)) {
//            re = NumberCommon.log2Recu(n);
            re = NumberCommon.log2(n);
        } else {
            System.out.println("这个数字不是2的幂次方");
        }
        return re;
    }

    public static void main(String[] args) {
        System.out.println(getPower2(256));

        //保留2位小数 方式1
        double d1 = 23.4234;
        System.out.println(df.format(d1));

        //保留2位小数 方式2
        BigDecimal bd = new BigDecimal(d1);
        double v = bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(v);

        //保留2位小数 方式3
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(2);
        System.out.println(nf.format(d1));

    }
}
