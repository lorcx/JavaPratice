package review;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 从字符串中截取第一个英文左括号之前的字符串
 * Created by lx on 2017/10/14.
 */
public class RegExpTest {
    public static void main(String[] args) {
        String str = "北京市(朝阳区)(西城区)(海淀区)";
        Pattern p = Pattern.compile(".*?(?=\\()");
        Matcher m = p.matcher(str);
        if (m.find()) {
            System.out.println(m.group());
        }
    }
}
