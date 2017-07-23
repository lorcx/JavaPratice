package design_model.flyweight; 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

/** 
 * @Description: 
 * @Create on: 2015-2-27 上午09:50:40
 * @Author:李欣
 * @Version:1.0
 */
public class ConnectionPool {
	private Vector<Connection> pool;//数据库连接池
	
	private int size = 100;
	private String url = "";
	private String driver = "";
	private String username = "";
	private String password = "";
	private Connection conn = null;
	private ConnectionPool instance = null;//连接池的实例
	
	//初始化的工作
	public ConnectionPool() {
		pool = new Vector<Connection>(size);
		for (int i = 0; i < pool.size(); i++) {
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url,username,password);
				pool.add(conn);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}
	 /* 返回连接到连接池 */  
	public synchronized void release(){
		pool.add(conn);
	}
	/* 返回连接池中的一个数据库连接 */
	public Connection getConnection(){
		if(pool.size() > 0){
			Connection conn = pool.get(0);
			pool.remove(conn);//使用的连接从池中移走
			return conn;
		}else{
			return null;
		}
	}
	
}
 