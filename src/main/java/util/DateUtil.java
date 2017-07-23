package util;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by dell on 2015/12/16.
 */
public class DateUtil {

    public static SimpleDateFormat format_YMD = new SimpleDateFormat("yyyy-MM-dd");
    public static SimpleDateFormat format_YMDHSD = new SimpleDateFormat("yyyy-MM-dd HH:ss:dd");

    /**
     * 设置时间为下周二
     * @return
     */
    public static String getAssignDate(){
        GregorianCalendar calendar = new GregorianCalendar();
        int day = calendar.get(Calendar.DAY_OF_MONTH);//日
        int month = calendar.get(Calendar.MONTH) + 1;//月
        int year = calendar.get(Calendar.YEAR);//年
        int hour = calendar.get(Calendar.HOUR_OF_DAY);//小时
//        int minute = calendar.get(Calendar.MINUTE);//分钟
//        int second = calendar.get(Calendar.SECOND);//秒
        int week = calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH);//星期几
        String dateStr = "";
        if(week == 2){//周二
            if(hour == 14){
                dateStr = format_YMDHSD.format(new Date());
            }else if(hour < 14){
                dateStr = year+"-"+month+"-"+day+" 14 : 00";
            }
        }else if(week < 2){ // < 2
            int n = 2 - week;
            calendar.set(Calendar.DAY_OF_MONTH,(day + n));
            dateStr = calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH) + 1) + "-" + calendar.get(Calendar.DAY_OF_MONTH) + " 14 : 00";
        }
        if((week == 2 && hour > 14) || (week > 2)){
            int n = week - 2;//计算与周二的差
            calendar.set(Calendar.DAY_OF_MONTH,(day + 7 - n));
            dateStr = calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH) + 1) + "-" + calendar.get(Calendar.DAY_OF_MONTH) + " 14 : 00";
        }
        return dateStr;
    }

    public void dateRange(int[] hours){
        Calendar cal = Calendar.getInstance();
        Date nowDate = new Date();
        long nowDateLong = nowDate.getTime();
        Date startDate = null;
        Date endDate = null;
        int tmp;
//        hours[hours.length + 1] = nowDate;
        long[] hourArr = new long[hours.length + 1];
        for(int i = 0;i < hours.length;i++){
            cal.set(Calendar.HOUR_OF_DAY,hours[i]);
            hourArr[i] = cal.getTime().getTime();
        }
        hourArr[hours.length] = nowDate.getTime();
        Arrays.sort(hourArr);
        for(int i = 0;i < hourArr.length;i++){
            if(hourArr[i] == nowDateLong){
                if(i == 0){
                    cal.set(Calendar.HOUR_OF_DAY,0);
                    startDate = cal.getTime();
                    cal.set(Calendar.HOUR_OF_DAY,(int)hourArr[i]);
                    endDate = cal.getTime();
                }else if(i > 0 && i <= hourArr.length - 2){
                    int s = (int) hourArr[i];
                    int s1 = (int) hourArr[i+1];
                    cal.set(Calendar.HOUR_OF_DAY,s);
                    startDate = cal.getTime();
                    cal.set(Calendar.HOUR_OF_DAY,s1);
                    endDate = cal.getTime();
                }else{
                    cal.set(Calendar.HOUR_OF_DAY, (int) hourArr[i -1]);
                    startDate = cal.getTime();
                    cal.set(Calendar.HOUR_OF_DAY, (int) hourArr[i]);
                    endDate = cal.getTime();
                }
            }
        }
        System.out.println(format_YMD.format(startDate));
        System.out.println(format_YMD.format(endDate));
    }
    public static void main(String[] args) {
//        getAssignDate();
//        System.out.println(getAssignDate());
        DateUtil dateUtil = new DateUtil();
        dateUtil.dateRange(new int[]{8,14,20});
    }
}
