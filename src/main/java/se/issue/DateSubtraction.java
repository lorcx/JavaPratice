package se.issue;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 为什么两个（1927年）时间相减得到一个奇怪的结果？
 * 
 * @author dell
 * 
 */
public class DateSubtraction {
	public static void main(String[] args) throws Exception {
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//格式化不能写错
		 String date1 = "1927-12-31 23:54:07";
		 String date2 = "1927-12-31 23:54:08";
		 Date d1 = sdf.parse(date1);
		 Date d2 = sdf.parse(date2);
		 long l1 = d1.getTime()/1000;
		 long l2 = d2.getTime()/1000;
		 System.out.println(l2 - l1);
		 /**
		  * 353
		  * 这是上海时区，在12月31日有一个变化。
		  *	查阅这个网址来了解上海在1927年时区变化的细节。
		  * 基本上在1927年年底的午夜，始终会回拨5分52秒。
		  * 所以“1927-12-31 23:54:08”实际上发生了两次，
		  * 看起来Java解析了后一次的时间作为当地的日期和时间导致了差异。
		  */
	 
	}
}
