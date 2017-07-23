package se.se.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * 简单的服务器    打印客户端的话
 * @author dell
 *
 */
public class EchoServer {
	public static void main(String[] args) {
		try {
			/* test cmd telnet ip + 端口    */
			ServerSocket serverSocket = new ServerSocket(8189);
			Socket so = serverSocket.accept();//使用一个套接字去监听这个端口    阻塞并等待连接
			InputStream in = so.getInputStream();//输入  读
			OutputStream ou = so.getOutputStream();//输出  写
			Scanner sc = new Scanner(in);
			PrintWriter pw = new PrintWriter(ou,true);//第二个参数为true 表示自动刷新
			boolean flag = false;
			while(!flag && sc.hasNextLine()){
				pw.println("echo:" + sc.nextLine());
				if(sc.nextLine().trim().equals("LX")){
					flag = true;
				}	
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
