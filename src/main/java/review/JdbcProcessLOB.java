package review;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * jdbc处理lob  mysql
 * Created by lx on 2017/10/14.
 */
public class JdbcProcessLOB {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            // 1 加载驱动类 java6以上可以忽略
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2 建立连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?characterEncoding=utf8&useSSL=false", "root", "lorcx");
            // 3 创建语句
            PreparedStatement ps = conn.prepareStatement("insert into tb_user values (default, ?, ?)");
            ps.setString(1, "骆昊");
            try (InputStream is = new FileInputStream("f:\\test.jpeg")) {
                ps.setBinaryStream(2, is);
                // 4 发出sql语句获得受影响行
                System.out.println(ps.executeUpdate() == 1? "插入成功" : "插入失败");
            } catch (IOException e) {
                System.out.println("读取照片失败");
            }
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
}
