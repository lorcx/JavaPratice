package se.se.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TheadSever {
	public static void main(String[] args) {
		ServerSocket serverSocket;
		try {
			int i = 0;//统计人数
			serverSocket = new ServerSocket(8189);
			while(true){
				Socket so = serverSocket.accept();//使用一个套接字去监听这个端口    阻塞并等待连接
				i++;
				System.out.println("当前在线人数:"+i);
				Runnable run = new ThreadSocket(so);
				Thread th = new Thread(run);
				th.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
