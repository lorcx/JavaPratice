package encrypt;

import java.security.MessageDigest;

/**
 * md5加密
 * @author dell
 *
 */

/**
 * 1、初始化MessageDigest信息摘要对象
 * 2、传入需要计算的字符串更新摘要对象
 * 3、计算信息摘要
 * 4、将byte[]转换为长度为32位的16进制字符串

 * @author Administrator
 *
 */
public class md5Demo {
	/**
	 * 生成MD5
	 * @throws Exception 
	 */
	public static void generateMD5(String str) throws Exception{
		//初始化MessageDigest信息摘要对象
		MessageDigest md = MessageDigest.getInstance("md5"); 
		//传入需要计算的字符串更新摘要对象
		md.update(str.getBytes("UTF-8"));
		byte[] hashCode = md.digest();
		StringBuilder sb = new StringBuilder();
		//将byte[]转换为长度为32位的16进制字符串
		for (byte b : hashCode) {
			sb.append(Character.forDigit((b >> 4) & 0xf, 16));
			sb.append(Character.forDigit(b & 0xf, 16));
		}
		System.out.println("加密后：" + sb.toString());
		
	}
	
	public static void main(String[] args) throws Exception {
		md5Demo.generateMD5("123");
	}
	
}
