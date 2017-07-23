package jdbc.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

/**
 * 将结果集存到缓存中
 * @author dell
 *
 */
public class dbTest1 {
	public static void main(String[] args) {
		Connection conn = DbConnection.getConnection();
		try {
			String tableName = "demo";
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery("select * from " + tableName);
			RowSetFactory rsFactory = RowSetProvider.newFactory();
			CachedRowSet crs = rsFactory.createCachedRowSet();
			crs.setTableName(tableName);
			crs.populate(rs);//将结果集放到缓存中
			
			//System.out.println(crs.previous());
			/*CachedRowSet取到的是一行*/
			if(crs.next()){//将游标移动到下一行
				System.out.println(crs.getString(1));
				System.out.println(crs.getString(2));
			}
			
			crs.deleteRow();//删除一行数据
			crs.acceptChanges(conn);//删除后的数据要回写到数据库


		} catch (SQLException e) {
			e.printStackTrace();
		}
		DbConnection.closeConn();
	}
}
