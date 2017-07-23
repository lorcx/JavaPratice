package jdbc.sql;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
/**
 * 获取元数据并输出所有的表
 *
 * @author dell
 *
 */
public class dbTest {
	public static void main(String[] args) throws Exception {
		Connection conn = DbConnection.getConnection();
		//获取数据库的元数据
		//元数据就是 ：关于数据库的信息
		DatabaseMetaData data = conn.getMetaData();
		ResultSet rs = data.getTables(null, null, null, new String[]{"TABLE"});
		while(rs.next()){
			System.out.println(rs.getString(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));//获取数据库中的所有表名
			System.out.println(rs.getString(4));
			System.out.println(rs.getString(5));
		}
		
		System.out.println(data.getJDBCMajorVersion()+"."+data.getJDBCMinorVersion());//jdbc版本
		System.out.println(data.getMaxConnections());//最大并发连接数
		
		DbConnection.closeConn();
	}
}
