package jdbc.sql;

import java.awt.Image;
import java.awt.image.RenderedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.imageio.ImageIO;


public class imageSave {
	public static void main(String[] args) {
		try {
			//连接数据库
			Class.forName("oracle.jdbc.dirver.OracleDriver");
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			String username = "llxx";
			String password = "lorcx";
			Connection conn = DriverManager.getConnection(url,username,password);
			
			//clob
			Clob clob = conn.createClob();
			long pos = 21312312;
			clob.setCharacterStream(pos);
			//blob
			Blob blob = conn.createBlob();
			OutputStream out = blob.setBinaryStream(123123);
			Image in = ImageIO.read(blob.getBinaryStream());
			
			String sql = "insert into image (id,content,content_b) values(1,?,?)";
			PreparedStatement ps = 	conn.prepareStatement(sql);
			int i = 0;
			ImageIO.write((RenderedImage) in, "name", out);
			//ps.set(1,blob);
		//	ps.set(2,clob);
			ps.execute();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
