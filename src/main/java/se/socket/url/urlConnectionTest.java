package se.socket.url;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import sun.misc.BASE64Encoder;

/**
 * urlConnection 返回http的头信息 
 *  用于返回 有密码保护的web页
 * @author dell
 *
 */
public class urlConnectionTest {
	public static void main(String[] args) {
		String urlName = "";
		if(args.length > 0){
			urlName = args[0];
		}else{
			urlName = "http://192.168.1.1/";
		}
		try {
			URL url = new URL(urlName);
			URLConnection conn = url.openConnection();
			Scanner sc = new Scanner(System.in);
			//if(args.length > 2){
				String username = sc.next();//args[1];  lorcx93520
				String password = sc.next();//args[2];   lorcx93520
				// NO.1 username:password base64加密
				String input = username+":"+password;
				String encode = new BASE64Encoder().encode(input.getBytes());//base64Encode(input);
				// NO.2 
				conn.setRequestProperty("Authorization", "Basic"+encode);
				conn.connect(); //建立url连接
				
				Map<String, List<String>> map = conn.getHeaderFields();//获取头信息
				for (Map.Entry<String, List<String>> entry : map.entrySet()) {
					String key = entry.getKey(); 
					for (String value : entry.getValue()) {
						System.out.println(key + ":" + value);
					}
				}
				System.out.println("----------------");
				System.out.println("ContentType"+conn.getContentType());
				System.out.println("ContentEncoding"+conn.getContentEncoding());
				System.out.println("ContentLength"+conn.getContentLength());
				System.out.println("getDate"+conn.getDate());
				System.out.println("LastModified"+conn.getLastModified());
				System.out.println("Expiration"+conn.getExpiration());
				System.out.println("----------------");

				Scanner in = new Scanner(conn.getInputStream());
				for (int i = 0;in.hasNext()&& i < 10; i++) {
					System.out.println(in.hasNext());
				}
				if(in.hasNext()){
					System.out.println(".....");
				}
		//	}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private static String base64Encode(String input) {
		return null;
	}

}
