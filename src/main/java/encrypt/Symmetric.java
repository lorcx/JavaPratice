package encrypt;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**encrypt(加密)
 * 
 * Symmetric(对称加密)
 * @author dell
 *
 */
public class Symmetric {
	/**
	 * Java Security提供了操作AES的类	
	 * 使用AES加密，AES是对称加密，可以接收处使用同样的算法解密
	 * encodeRules可以看作是内容加密的密钥，通常情况下，encodeRules是作为一组密码提供的
	 * 加密过程如下：
	 * 1.构造密钥生成器
	 * 2.利用用户提供的password产生随机源来初始化密钥生成器
	 * 3.产生密钥
	 * 4.创建和初始化密码器
	 * 5.将内容加密
	 * 6.将加密内容的byte[]数组转换为字符串并返回
	 * @throws Exception 
	 *  	
	 */
	public static String AESEncode(String encodeRules,String content) throws Exception{//密钥    内容
		//构造密钥生成器，指定使用AES算法
		KeyGenerator key = KeyGenerator.getInstance("AES");
		/*	
		 * 初始化密钥生成器。
		 * 第一个参数指定当前密钥的大小，这个参数的取值与指定算法有关
		 * 第二个参数是一个随机源，它产生的结果与encodeRules有关
		 */
		key.init(128,new SecureRandom(encodeRules.getBytes()));
		/*
		 * 产生一个原始对称密钥
		 */
		SecretKey original_key  = key.generateKey();
		//获得原始对称密钥的字节
		byte[] raw = original_key.getEncoded();
		/*
		 * 使用SecretKeySpec根据一个字节数组构造一个key
		 * 这个过程可以不需要使用SecretFactory，因为此类与Provider无关
		 * Provider是一个提供了加密算法并且可以管理密钥的类
		 * SecretKeySpec只能对表示为字节数组的原始密钥起作用，并且，这个原始密钥不能有任何钥参数 
		 */
		SecretKeySpec sks = new SecretKeySpec(raw, "AES");
		/*
		 * 根据指定算法创建密码器，  
		 */
		Cipher cipher = Cipher.getInstance("AES");
		/*
		 * 初始化密码器
		 * 第一个参数表示使用何种操作，这里是加密
		 * 第二个参数表示密钥
		 */
		cipher.init(Cipher.ENCRYPT_MODE, sks);
		/*
		 * 获取需要加密内容的字节数组
		 */
		byte[] byte_encode = content.getBytes("UTF-8");
		/*
		 * 根据密码器初始化的方式，数据将被加密或者解密
		 */
		byte[] byte_AES = cipher.doFinal(byte_encode);
		/*
		 * 将加密后数据转换为字符串
		 */
		String AES_encode = new BASE64Encoder().encode(byte_AES);
		
		return AES_encode;
	}
	/*
	 * 	使用AES解密 
	 * 	解密过程与加密过程类似，具体过程如下：
	 * 	1.同加密的1--4步骤 
	 * 	2.将加密后的字符串反编码回byte[]数组
	 * 	3.将加密内容解密
	 */
	public static String AESDecode(String encodeRules,String content) throws Exception{
		/*
		 * 此部分与加密部分相同
		 */
		KeyGenerator keygen = KeyGenerator.getInstance("AES");
		keygen.init(128, new SecureRandom(encodeRules.getBytes()));
		SecretKey original_key = keygen.generateKey();
		byte[] raw = original_key.getEncoded();
		SecretKeySpec keySpec = new SecretKeySpec(raw,"AES");
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.DECRYPT_MODE,keySpec);
		byte[] byte_content = new BASE64Decoder().decodeBuffer(content);
		byte[] byte_decode_AES = cipher.doFinal(byte_content);
		String code = new String(byte_decode_AES,"UTF-8");
		return code;
		
		
	}
	
	public static void main(String[] args) throws Throwable {
		String encodeRules = "abcd";//加密规则
		String content = "123456789";
		String code = Symmetric.AESEncode(encodeRules,content);//密码
		System.out.println("加密后"+code);
		encodeRules = "abcd";//解密规则
		System.out.println(Symmetric.AESDecode(encodeRules,code));
	}
}
