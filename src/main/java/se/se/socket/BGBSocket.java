package se.se.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * 半关闭socket 
 * @author dell
 *
 */
public class BGBSocket {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("host",8080);
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			Scanner input = new Scanner(in);
			PrintWriter pw = new PrintWriter(out);
			while(input.hasNext()){
				if(input.nextLine() != null || input.nextLine() !=""){
					pw.print(input.nextLine());
				}else{
					socket.shutdownInput();  //半关闭流   
				}
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
