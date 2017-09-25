package se.socket;

import java.net.InetAddress;

public class InetAddressDemo {
	public static void main(String[] args) throws Exception {
		InetAddress address = InetAddress.getLocalHost();
		System.out.println(address);//获取  主机名/ip地址
		String hostName = address.getHostName();//获取本地的主机名
		System.out.println(hostName);
		
		//获取外网的主机  如百度
		String bai = "www.baidu.com";
		String goo = "www.google.com";
		InetAddress[] i = InetAddress.getAllByName(goo);
		for (InetAddress ine : i) {
			System.out.println(ine);
		}
	}
}
