package craw;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author lx
 * @Date 2018/3/10 16:37
 */
public class BuildCrawData {

//    private List<String> parseImgUrl() {
//        String filePath = "H:\\abc.html";
//        Path path = Paths.get(filePath);
//        StringBuilder html = new StringBuilder();
//        try (BufferedReader reader = Files.newBufferedReader(path)) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                html.append(line).append("\n");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        List<String> list = new ArrayList<>();
//        Document doc = Jsoup.parse(html.toString());
//        Elements elements = doc.select("a[href]");
//
//        for (Element ele : elements) {
//            String href = ele.attr("href");
//            list.add(href);
//        }
//        return list;
//    }

    public static void fileCopy(File s, File t) {
        FileInputStream fi = null;
        FileOutputStream fo = null;
        FileChannel in = null;
        FileChannel out = null;
        try {
            fi = new FileInputStream(s);
            fo = new FileOutputStream(t);
            out = fo.getChannel();
            in = fi.getChannel();
            in.transferTo(0, in.size(), out);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fi != null) {
                    fi.close();
                }
                if (in != null) {
                    in.close();
                }
                if (fo != null) {
                    fo.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
            }
        }
    }

    public void insertMerchant(int mchntId, String img1, String img2, String img3, String img4) throws ParseException {
        int contPhone = (int) ((Math.random() * 9 + 1) * 100000000);
        String date = RandomTime.getDate("2017-06-08", "2018-03-09");
        String sql = "INSERT INTO `t_merchant` VALUES ('" + mchntId + "', NULL, '029207', '100', '1', '方式', '支行33333333', '', '', '', '', '', '', '209', '', '110', '1000', '1001', '身份', '00', '142431199025694875', '" + img1 + "', '" + img2 + "','" + img3 + "', '" + img4 + "', '', '1', '', '" + date + "', '18201616110', '" + date + "', '18201616110', '1', '张三', '1', '六六六', '" + contPhone + "', '', '德尔', '5F1135FE92EA4D20A801354A70F5A3AF', NULL, '0', '0', NULL, NULL, NULL, '029187029191029207')";

        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/nxydb?characterEncoding=utf8&useSSL=false&serverTimezone=UTC", "root", "lorcx");
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            System.out.println("插入成功");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != conn && !conn.isClosed()) {
                    conn.close();
                    conn = null;//指示垃圾回收
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BuildCrawData b = new BuildCrawData();
        int total = 10;
        ExecutorService exec = Executors.newFixedThreadPool(10);
        File f = new File("G:\\test_pic");
//        if (f.exists()) {
//            for (int i = 0; i < total; i++) {
//                File[] files = f.listFiles();
//                if (files != null) {
//                    exec.execute(() -> {
//                        for (File file : files) {
//                            fileCopy(file, new File("G:\\test_pic\\" + UUID.randomUUID().toString() + ".jpg"));
//                        }
//                    });
//                }
//            }
//        }


        File[] files = f.listFiles();
        if (f.exists()) {
            for (int n = 0; n < files.length - 4; n = n + 4) {
                try {
                    b.insertMerchant(900 + n, files[n].getName(), files[n + 1].getName(), files[n + 2].getName(), files[n + 3].getName());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }


//        File[] files = f.listFiles();
//        exec.execute(() -> {
//            if (files != null) {
//                for (File file : files) {
//                    file.delete();
//                }
//            }
//        });
//
//        exec.execute(() -> {
//            if (files != null) {
//                for (int i = files.length - 1; i > 0; i--) {
//                    files[i].delete();
//                }
//            }
//        });
        exec.shutdown();
    }
}


class RandomTime {
    public static String getDate(String beginDate, String endDate) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date start = format.parse(beginDate);
        Date end = format.parse(endDate);
        if (start.getTime() >= end.getTime()) {
            return null;
        }
        long date = random(start.getTime(), end.getTime());
        return format.format(new Date(date));
    }

    private static long random(long begin, long end) {
        long rtn = begin + (long) (Math.random() * (end - begin));
        if (rtn == begin || rtn == end) {
            return random(begin, end);
        }
        return rtn;
    }
}
