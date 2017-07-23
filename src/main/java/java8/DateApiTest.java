package java8;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

/**
 * Created by lx on 2016/11/27.
 */
public class DateApiTest {
    public static void main(String[] args) {
        // 获得当前的日期和时间
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println("current date and time " + currentTime);

        //输出当前时间的本地值 （本时区）
        LocalDate date = currentTime.toLocalDate();
        System.out.println("local date " + date);

        Month month = currentTime.getMonth();
        int day = currentTime.getDayOfMonth();
        int seconds = currentTime.getSecond();

        System.out.println(month);
        System.out.println(seconds);

        // 各个字段
        System.out.println("month:" + month + "day" + day + "seconds" + seconds);

        LocalDateTime date2 = currentTime.withDayOfMonth(10).withYear(2012);
        System.out.println(date2);

        // 2016圣诞节日期
        LocalDate date3 = LocalDate.of(2016,Month.DECEMBER,25);
        System.out.println(date3);

        LocalTime date5 = LocalTime.parse("20:15:30");
        System.out.println("date 5" + date5);

        // 将字符串代表的时区信息转换
        ZonedDateTime date6 = ZonedDateTime.parse("2016-04-20T19:22:15+01:30[Europe/Paris]");
        System.out.println("date6" + date6);

        // 设定地区Id 为亚洲的加尔各答 （印度）
        ZoneId id = ZoneId.of("Asia/Kolkata");
        System.out.println("ZoneId " + id);

        // 获得系统默认时区
        ZoneId currentTime2 = ZoneId.systemDefault();
        System.out.println("CurrentZone" + currentTime2);

        // 当前时间
        LocalDate today = LocalDate.now();
        System.out.println(today);

        // 当前时间+2周
        LocalDate nextWeek = today.plus(2, ChronoUnit.WEEKS);
        System.out.println(nextWeek);

        // 当前日期加6个月
        LocalDate nextMonth = today.plus(6,ChronoUnit.MONTHS);
        System.out.println(nextMonth);

        // 当前日期加5年
        LocalDate nextYear = today.plus(5,ChronoUnit.YEARS);
        System.out.println(nextYear);

        // 当前日期加20年
        LocalDate nextDecde = today.plus(2, ChronoUnit.DECADES);
        System.out.println(nextDecde);

        // 计算2个日期间隔
        Period period = Period.between(nextWeek, today);
        System.out.println(period);

        LocalTime time1 = LocalTime.now();
        Duration fiveHours = Duration.ofHours(5);
        LocalTime time2 = time1.plus(fiveHours);
        Duration duration = Duration.between(time1, time2);
        System.out.println(duration);


        LocalDate nextMonday = today.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        System.out.println(nextMonday);

        LocalDate firstInYear = LocalDate.of(today.getYear(),today.getMonth(),1);
        LocalDate secondSunday = firstInYear.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY)).with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        System.out.println(secondSunday);

        Date currentDate = new Date();

        System.out.println("Current date " + currentDate);

        Instant now = currentDate.toInstant();
        ZoneId currentZone = ZoneId.systemDefault();

        LocalDateTime localDateTime = LocalDateTime.ofInstant(now, currentZone);
        System.out.println("local date " + localDateTime);

        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(now , currentZone);
        System.out.println(zonedDateTime);



    }
}
