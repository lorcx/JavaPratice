package se.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SocketDemo {
	public static void main(String[] args) {
		try {
			Socket so = new Socket("time-A.timefreq.bldrdoc.gov",13);
			InputStream in = so.getInputStream();
			Scanner input = new Scanner(in);
			while(input.hasNextLine()){
				System.out.println(input.nextLine());
			}
			
			
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
