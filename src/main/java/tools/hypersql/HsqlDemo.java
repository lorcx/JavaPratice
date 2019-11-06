package tools.hypersql;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @Author lx
 * @Date 2019/2/3 22:31
 */
public class HsqlDemo {
    public static void main(String[] args) {
        // 1 获得基本连接
        /*try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            Connection c = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/xdb", "SA", "");
            System.out.println(c);
        } catch (Exception e) {
            e.printStackTrace();
        }*/


        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            Connection c = DriverManager.getConnection("jdbc:hsqldb:file:D:\\soft\\hsqldb-2.4.1\\hsqldb\\testdb;ifexists=false", "SA", "");
            System.out.println(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
