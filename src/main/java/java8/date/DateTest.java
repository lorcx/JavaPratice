package java8.date;

import java.time.LocalDate;
import java.time.Period;

public class DateTest {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        LocalDate birthLocalDate = LocalDate.of(1993, 5, 20);
        Period period = Period.between(birthLocalDate, now);
        System.out.println("年：" + period.getYears() + " 月:" + period.getMonths() + " 日:" + period.getDays());
    }
}
