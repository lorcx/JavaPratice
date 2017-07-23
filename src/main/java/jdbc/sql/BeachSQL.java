package jdbc.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 批处理
 * @author dell
 *
 */
public class BeachSQL {
	public static void main(String[] args) throws Exception {
		Connection conn = DbConnection.getConnection();
		conn.setAutoCommit(false);
		String sql1 = "insert into demo(did,dname)values('998','abcd')";
		String sql2 = "insert into demo(did,dname)values('999','abcd')";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql1);
			PreparedStatement ps1 = conn.prepareStatement(sql2);
			ps.addBatch();
			ps1.addBatch();
			ps.executeBatch();
			ps1.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		conn.commit();
		DbConnection.closeConn();
	}
}
