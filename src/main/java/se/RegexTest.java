package se;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: lx
 * @Date: Created in 2020/2/29
 */
public class RegexTest {
    static public final String POEM =
            "Twas brillig, and the slithy toves\n" +
                    "Did gyre and gimble in the wabe.\n" +
                    "All mimsy were the borogoves,\n" +
                    "And the mome raths outgrabe.\n\n" +
                    "Beware the Jabberwock, my son,\n" +
                    "The jaws that bite, the claws that catch.\n" +
                    "Beware the Jubjub bird, and shun\n" +
                    "The frumious Bandersnatch.";

    public static void main(String[] args) {
        /*String str = "abcdABCD";
        Pattern pattern = Pattern.compile("(?i)[abcd]");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }*/


        // (?m) 多行匹配模式也可以通过compiler(pattern, flags)第二个参数设置多行匹配
        // 这个正则表达式中有一个「$」行尾的匹配
        // \S: 匹配任意不是空白符的字符
        // \s: 匹配任意的空白符
        /*Matcher m = Pattern.compile("(?m)(\\S+)\\s+((\\S+)\\s+(\\S+))$").matcher(POEM);
        while (m.find()) {
            for (int j = 0; j <= m.groupCount(); j++) {
                System.out.println("[" + m.group(j) + "]");
            }
            System.out.println();
        }*/


        String reg = "(?i)\\w+?[aeiou]\\b";
        System.out.println("Regular expression: \"" + reg + "\"");
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher("Arline ate eight apples and one orange while Anita hadn't any");
        while (m.find()) {
            System.out.println("Match \"" + m.group() + "\" at position " +
                    m.start() + ((m.end() - m.start() < 2) ? "" : ("-" + (m.end() - 1))));
        }
    }
}
