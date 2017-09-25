package se.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ThreadSocket implements Runnable {
	private Socket so;
	public ThreadSocket(Socket so){
		this.so = so;
	}

	public void run() {
		try {
			InputStream in = so.getInputStream();//输入  读
			OutputStream ou = so.getOutputStream();//输出  写
			Scanner sc = new Scanner(in);
			PrintWriter pw = new PrintWriter(ou,true);//第二个参数为true 表示自动刷新
			String title = new String("====hello! 退出请输入LX====".getBytes("utf-8"));
			pw.println(title);
			boolean flag = false;
			while(!flag && sc.hasNextLine()){
				pw.println("echo:" + sc.nextLine());
				if(sc.nextLine().trim().equals("LX")){
					flag = true;
				}	
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				so.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
			
	}

}
