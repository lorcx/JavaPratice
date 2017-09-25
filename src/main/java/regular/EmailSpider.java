package regular;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 获取源文件中所有email地址
 * Created by dell on 2016/9/4.
 */
public class EmailSpider {

    static List<String> data = new ArrayList<String>();

    static String dir = System.getProperty("user.dir") + "/src/regular/";

    public static void main(String[] args) {
        BufferedReader br = null;
        try {
           br = new BufferedReader(new FileReader(dir + "/123.html"));
           String line;
           while ((line = br.readLine()) != null) {
               parse(line);
           }
           writeLog();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 解析查找email
     * @param line
     */
    private static void parse(String line) {
        Pattern p = Pattern.compile("[\\w[.-]]+@[\\w[.-]]+\\.[\\w]+");
        Matcher m = p.matcher(line);
        while (m.find()) {
            data.add(m.group());
        }
    }

    /**
     * 将记录写到当前目录下
     */
    public static void writeLog() {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(dir + "/log.txt"));
//            byte[] b = new byte[1024];
            for (String d : data) {
                bw.write(d + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
           try {
             if (bw != null) {
               bw.close();
             }
           } catch (IOException e) {
               e.printStackTrace();
           }
        }
    }
}
