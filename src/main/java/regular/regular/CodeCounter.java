package regular;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * 正则表达式检查代码有效行数
 * Created by dell on 2016/9/5.
 */
public class CodeCounter {

    static int whiteLines = 0;// 空白行
    static int normalLines = 0;// 代码行
    static int commentLines = 0;// 注释行

    static String location = System.getProperty("user.dir") + "/src/poi/";

    public static void main(String[] args) {
        File dir = new File(location);
        if (dir.exists()) {
            File[] fileList = dir.listFiles();
            if (null != fileList && fileList.length > 0) {
                for (File child : fileList) {
                    if (child.getName().matches(".*\\.java$")) {// 匹配以java 为结尾的
                        parse(child);
                    }
                }
            }
        }
        System.out.println("nomal : " + normalLines);
        System.out.println("comment : " + commentLines);
        System.out.println("white : " + whiteLines);
//        System.out.println("".matches("^[\\s&&[^\\n]]*$"));

    }

    /**
     * 解析查找email
     * @param :file
     */
    private static void parse(File file) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            String line;
            boolean commentRange = false;// 是否在注释范围内
            while ((line = br.readLine()) != null) {// readline已经把\n拿掉了
                line = line.trim();
                // 空白行
                if (line.matches("^[\\s&&[^\\n]]*$")) {
                    whiteLines++;
                } else if (line.startsWith("/*") && !line.endsWith("*/")) {
                    commentLines++;
                    commentRange = true;
                } else if (line.startsWith("/*") && line.endsWith("*/")) {
                    commentLines++;
                } else if (commentRange) {// 注释中 或 结尾
                    if (line.startsWith("*/")) {// 注释结尾
                        commentRange = false;
                    }
                    commentLines++;
                } else if(line.startsWith("//")) {
                    commentLines++;
                } else {// 代码行
                    normalLines++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
//                    br = null;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 递归文件夹
     */
//    public void recursionParse(String location) {
//        File dir = new File(location);
//        if (dir.exists()) {
//            File[] fileList = dir.listFiles();
//            if (null != fileList && fileList.length > 0) {
//                for (File child : fileList) {
//                    if (child.isDirectory()) {// dir
//                        recursionParse(child.getAbsolutePath());
//                    } else {// file
//                        if (child.getName().matches(".*\\.java$")) {// 匹配以java 为结尾的
//                            parse(child);
//                        }
//                    }
//                }
//            }
//        }
//    }
}
