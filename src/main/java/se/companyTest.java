package se;

import org.apache.commons.lang3.StringUtils;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Author: lx
 * @Date: Created in 2018/9/20 0020
 */
public class companyTest {
    public static void main(String[] args) {
        String abc = StringUtils.leftPad("abc", 10);
        System.out.println(abc);

        String bbb = StringUtils.rightPad("bbb", 5);
        System.out.println(bbb);

        String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(now);

        String format = String.format("%s%s", LocalDateTime.now().
                        format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")),
                StringUtils.leftPad("123456", 6, "0"));
        System.out.println(format);


        String format1 = new DecimalFormat("000000").format(1);
        System.out.println(format1);
    }
}
