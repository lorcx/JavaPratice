package encrypt;

import java.security.MessageDigest;

import sun.misc.BASE64Encoder;

public class HashEncode {
	/**
	 * md5加密
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public static String MD5Encode(String password) throws Exception{
		MessageDigest md = MessageDigest.getInstance("md5");
		md.update(password.getBytes("UTF-8"));
		byte[] hash = md.digest();
		String md5Code = new String(new BASE64Encoder().encode(hash));
		return md5Code;
	}
	
	public static void main(String[] args) throws Throwable {
		System.out.println(HashEncode.MD5Encode("123"));;
	}
}
