package regular;

import java.util.regex.Pattern;

/**
 * 正则表达式学习
 * Created by lx on 2016/9/4.
 */
public class RegularStudy {
    public static void main(String[] args) {
        String testStr = "time=\"2016-05-06 12:30:15\" name=\"liny\" age=\"423\" " +
                         "time=\"2016-05-06 12:30:15\" name=\"liny\" age=\"123\" " +
                         "time=\"2016-05-06 12:30:15\" name=\"liny\" age=\"763\" ";
//        String rpStr = testStr.replaceAll("time.{22}\\s", "");
//        List<Integer> list = new ArrayList<>();
        Pattern p = Pattern.compile("time=");
        String[] str = p.split(testStr);
        for (String s : str) {
            System.out.println(s);
        }
//        Matcher m = p.matcher(testStr);
//        while (m.find()) {
//            System.out.println(m.group(0));
//        }
//        Matcher m = p.matcher(rpStr);
//        while (m.find()) {
//            list.add(m.start());
//        }
//        for (int i = 0, len = list.size(); i < len; i++ ) {
//            if (i == len - 1) {
//                System.out.println(rpStr.substring(list.get(i)));
//            }else {
//                System.out.println(rpStr.substring(list.get(i), list.get(i + 1)));
//            }
//        }
    }
}
