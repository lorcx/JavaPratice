package codewars;

/**
 * @Author: lx
 * @Date: Created in 2020/2/29
 */
public class Troll {

    /**
     * 删除元音
     *
     * @param str
     * @return
     */
    /*public static String disemvowel(String str) {
        String[] vowelArray = {"a", "e", "i", "o", "u"};
        for (String vowel : vowelArray) {
            str = str.replace(vowel, "");
            str = str.replace(vowel.toUpperCase(), "");
        }

        return str;
    }  */

    /**
     * 删除元音
     * 最佳解决方案
     *
     * @param str
     * @return
     */
    public static String disemvowel(String str) {
        return str.replaceAll("[aeiou]", "");
    }
}
