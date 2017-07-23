package regular;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * regular.regular express
 * 尚学堂教学
 * Created by lx on 2016/9/4.
 */
public class RegExp {

    public static void main(String[] args) {
        // 简单的认识下正则表达式
        System.out.println("abc".matches("..."));
        // 将数字替换成 -
        System.out.println("a12839acd".replaceAll("\\d","-"));
        // pattern 代表了模式 matcher 代表了匹配器
        Pattern p = Pattern.compile("[a-z]{3}"); // 编译正则表达式
        Matcher m = p.matcher("fwe");
        System.out.println(m.matches());// 是否匹配

        // . * ? +
        /**
         *  . 任意一个字符
         *  * 0 - 任意
         *  ? 0 - 1
         *  + 1 - 任意
         *  {} 代表个数范围
         */
        System.out.println("aaa".matches("a*"));
        System.out.println("aaa".matches("a?"));
        System.out.println("aaa".matches("a+"));
        System.out.println("aaa".matches("aaa"));
        System.out.println("a".matches("."));
        System.out.println("".matches("."));
        System.out.println("".matches("a*"));
        System.out.println("".matches("a+"));
        System.out.println("".matches("a?"));
        System.out.println("ip = " + "192.168.1.abc".matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}"));
        System.out.println("192".matches("[0-2][0-9][0-5]"));

       // 范围 []
        /**
         * ^ 取反
         * 只匹配一个字符
         * 最后三个都是 或者 or 写法不同
         */
        System.out.println("---范围----");
        System.out.println("a".matches("[abc]"));
        System.out.println("a".matches("[^abc]"));
        System.out.println("a".matches("[a-z]"));
        System.out.println("a".matches("[a-z]&&[A-Z]"));
        System.out.println("a".matches("[a-zA-Z]"));
        System.out.println("a".matches("[a-z[A-Z]]"));
        System.out.println("a".matches("[a-z]|[A-Z]"));

        // \s \d \w \
        /**
         *  大写是小写的取反
         *  s 空格 \t \s \n ..
         *  w 数字字母下划线 单词
         *  d 数字
         *  \ 反斜杠
         */
        System.out.println("---- \\s \\d \\w \\----");
        System.out.println("\t\f\n".matches("\\s{3}"));
        System.out.println("abc".matches("\\w{3}"));
        System.out.println("(((".matches("\\W{3}"));
        System.out.println("(((".matches("\\d{3}"));
        System.out.println("(((".matches("\\D{3}"));
        System.out.println("\\".matches("\\\\"));// 前边的反斜杠是java字符串转义 后边是 正则表达式转义 写\\被认为是特殊字符所以写两次

        // 单词边界 bondary
        /**
         * \b 单词的边界
         * ^ 开始
         * $ 结束
         */
        System.out.println("----边界---");
        System.out.println("sdfh".matches(".dfh$"));// 第一个任意字符 并且 以dfh为结尾的
        System.out.println("qwe".matches("^q\\w{2}"));// 以q为开头
        System.out.println("abc bbe".matches("\\w{3}\\b.*"));
        // 匹配空白行
        System.out.println(" \n".matches("^[\\s&&[^\\n]]*\\n$"));// 开头是一个空白符 并且不是一个换行符 最后一换行符为结尾

        // 练习
        System.out.println("---练习-----");
        System.out.println("aaa 888c".matches(".*\\d{3}."));
        System.out.println("aaa 888c".matches(".*\\b\\d{3}."));
        System.out.println("aaa888c".matches(".*\\d{3}."));
        System.out.println("aaa888c".matches(".*\\b\\d{3}."));

        // email
        String email = "asdfasdfa@asd.com";
        System.out.println("email = " + email.matches("[\\w[.-]]+@[\\w[.-]]+\\.[\\w]+"));

        // find 找字串
        System.out.println("-----find-----");
        Pattern p1 = Pattern.compile("\\d{3,5}");
        Matcher m1 = p1.matcher("123-34344-213-00");
        System.out.println(m1.matches());// 匹配整个字符
        m1.reset();
        System.out.println(m1.find());// 匹配其中某部分
        System.out.println(m1.start() + "-" + m.end());
        System.out.println(m1.find());
        System.out.println(m1.start() + "-" + m.end());
        System.out.println(m1.find());
        System.out.println(m1.start() + "-" + m.end());
        System.out.println(m1.lookingAt());
        /**
         * 正则会从左到右每一个字符开始匹配 找到一个匹配后 下次就会从剩余的字符串中去寻找
         * lookingAt 是每次都从头上找
         * start 找到匹配的字串的起始位置
         * end 找到匹配的字串的结束位置
         */


        /**
         *  替换 偶数替换大写 奇数替换小写
         */
        Pattern p2 = Pattern.compile("java",Pattern.CASE_INSENSITIVE); // 忽略大小写
        Matcher m2 = p1.matcher("java Java JaVa IlovejAVA IHateJava asdfasdf");
        StringBuffer sb = new StringBuffer();
        int i = 0;
        while (m2.find()) {
            i++;
            if (i % 2 == 0) {
                m2.appendReplacement(sb,"java");
            } else {
                m2.appendReplacement(sb,"JAVA");
            }
        }
        m2.appendTail(sb);
        System.out.println(sb);


        // group 分组
        /**
         *  如何知道是第几组： 只要数左边的小括号就可以了
         *  ()
         */
        System.out.println("-----group------");
        Pattern p3 = Pattern.compile("(\\d{3,5})([a-z]{2})"); // 一共有3组 每组都对应一个下标 0 1 2
        Matcher m3 = p3.matcher("231aa-45345bb-126cc-00");
        while (m3.find()) {
            System.out.println(m3.group(1));// 输入第一组 : 3-5个数字
            System.out.println(m3.group(2));// 输出第二组 : 2个字母
        }

        // qulifiers
        /**
         *  什么都不加 是 贪婪的模式 ：上来就把最大个数的字符吞入 ，如果不符合吐出一个 ，在匹配
         *  ？ 是懒得模式 ： 上来吞入最小个数的字符 ，如果不符合就吞一个，在匹配
         *  + 独占模式 ： 跟贪婪的类似但 如果不匹配 也不会吐或吞
         */
        System.out.println("----------qulifiers----------");
        Pattern p4 = Pattern.compile("(.{3,10}?)[0-9]");
        Matcher m4 = p4.matcher("aaaa4bbbb69");
        while (m4.find()) {
            System.out.println("start = " + m4.start() + "end = " + m4.end());
            System.out.println(m4.group());
        }

        System.out.println("a".matches("."));

        // back reference
        /**
         *  \\1 \\2 数字代表匹配之前的组号
         *  如果\\1 表示下一个也匹配 (\\d(\\d) )( 数第一个左括号 内的  )
         */
        System.out.println("---------- back reference----------");
        Pattern p5 = Pattern.compile("(\\d(\\d))\\1");
        Matcher m5 = p5.matcher("111");
        while (m5.find()) {
            System.out.println(m5.group());
        }

    }
}
