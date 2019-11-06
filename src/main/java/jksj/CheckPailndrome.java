package jksj;

/**
 * 检查是否为回文字符串
 *
 * @Author: lx
 * @Date: Created in 2019/11/6 0006
 */
public class CheckPailndrome {
    public static void main(String[] args) {
        String str = "level";
        boolean b = check(str);
        assert b;

        str = "noon";
        b = check(str);
        assert b;
    }

    private static boolean check(String str) {
        char[] chars = str.toCharArray();
        int i = 0;
        int j = chars.length - 1;
        for (; i < j; i++, j--) {
            if (chars[i] != chars[j]) {
                return false;
            }
        }
        return true;
    }
}
