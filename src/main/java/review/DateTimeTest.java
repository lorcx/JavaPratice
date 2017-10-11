package review;

import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Administrator on 2017/10/11 0011.
 */
public class DateTimeTest {
    public static void main(String[] args) {
        /**
         * - 如何取得年月日、小时分钟秒？
         *        Calendar LocalDateTime
         * - 如何取得从1970年1月1日0时0分0秒到现在的毫秒数？
         *        系统时间就是从1970年以后算的
         * - 如何取得某月的最后一天？
         *        Calendar的getActualMaximum方法
         * - 如何格式化日期？
         *        DateFormtter的子类 SimpleDateFormat
         *        DateTimeFormtter
         */

        // 问题1
        Calendar cal = Calendar.getInstance();
        System.out.println(cal.get(Calendar.YEAR));
        System.out.println(cal.get(Calendar.MONTH) + 1);// 0 - 11
        System.out.println(cal.get(Calendar.DATE));
        System.out.println(cal.get(Calendar.HOUR_OF_DAY));
        System.out.println(cal.get(Calendar.MINUTE));
        System.out.println(cal.get(Calendar.SECOND));

        LocalDateTime dt = LocalDateTime.now();// JAVA8
        System.out.println(dt.getYear());
        System.out.println(dt.getMonthValue());
        System.out.println(dt.getDayOfMonth());
        System.out.println(dt.getHour());
        System.out.println(dt.getMinute());
        System.out.println(dt.getSecond());

        // 问题2
        System.out.println(Calendar.getInstance().getTimeInMillis());
        System.out.println(System.currentTimeMillis());
        System.out.println(Clock.systemDefaultZone().millis()); // JAVA8

        // 问题3
        System.out.println(cal.getActualMaximum(Calendar.DAY_OF_MONTH));
//        System.out.println(cal.getActualMinimum(Calendar.DAY_OF_MONTH));

        // 问题4
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date date1 = new Date();
        System.out.println(sdf.format(date1));

        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime date2 = LocalDateTime.now();
        System.out.println(date2.format(format));
    }
}
