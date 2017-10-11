package review;

import java.util.Calendar;

/**
 * Created by Administrator on 2017/10/11 0011.
 */
public class YesterdayCurrent {
    public static void main(String[] args) {
        /**
         * 打印昨天当前时间
         */
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        System.out.println(calendar.getTime());
    }
}
