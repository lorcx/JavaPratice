package se.se.socket.url;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

/**
 * 使用urlConnection传递参数
 * @author dell
 *
 */
public class PostTest {
	public static void main(String[] args) throws Exception {
		Properties prop = new Properties();
		try {
			prop.load(PostTest.class.getResourceAsStream("/se/se/socket/url/post.properties"));
			String url = prop.remove("url").toString();
			String result = post(url,prop);
			System.out.println(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static String post(String url , Map<Object, Object> map) throws Exception{
		StringBuilder sb = new StringBuilder();
		URLConnection conn = null;
		try {
			URL url2 = new URL(url);
		    conn = url2.openConnection();
			conn.setDoOutput(true);//打开输入流   默认是关闭的
			OutputStream out = conn.getOutputStream();
			PrintWriter pw = new PrintWriter(out);
			for (Map.Entry<Object, Object> entry : map.entrySet()) {
				String key =  entry.getKey().toString();
				String value = entry.getValue().toString();
				boolean first = true;
				if(first){
					first = false;
				}else{
					pw.print("&");
				}
				pw.print(key + "=" + URLEncoder.encode(value,"utf-8"));
			}
			InputStream in = conn.getInputStream();
			Scanner input = new Scanner(in);
			while(input.hasNext()){
				sb.append(input.nextLine());
				sb.append("\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
			if(!(conn instanceof HttpURLConnection)){
				throw e;
			}
			InputStream in = ((HttpURLConnection)conn).getErrorStream();
			if(in != null){
				Scanner sc = new Scanner(in);
				while(sc.hasNext()){
					System.out.println(sc.nextLine());
				}
			}
			
		}
		
		return sb.toString();
	}
}
