package util;

import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * base64算法加密
 * @author dell
 *
 */
public class base64JM extends FilterOutputStream {
	
	private static char[] tobase64 = {'A','B','C','D','E','F','G','H','I','G','K'
								,'L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'
								,'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p',
								'q','r','s','t','u','v','w','x','y','z','1','2','3','4','5','6',
								'7','8','9','0','+','/'	
								};
	private int col = 0;
	private int i = 0;
	private int [] inbuf = new int[3];
	
	public base64JM(OutputStream out) {
		super(out);
	}

	
	public static String base64Encode(String str){
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		base64JM jm = new base64JM(bos);
		try {
			jm.write(str.getBytes());
			jm.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bos.toString();
	}
	
	@Override
	public void write(int c) throws IOException {
		inbuf[i] = c;
		i++;
		if(i == 3){
			if(col >= 76){//76 是 L
				super.write('\n');
				col = 0;
			}
			super.write(tobase64[(inbuf[0] & 0xFc) >> 2]);
			super.write(tobase64[((inbuf[0] & 0x03) << 4) | ((inbuf[1] & 0xF0) >> 4)]);
			super.write(tobase64[((inbuf[1] & 0x0F) << 2) | ((inbuf[1] & 0xC0) >> 6)]);
			super.write(tobase64[inbuf[2] & 0x3F]);
			col += 4;
			i = 0;
		}
	}
	
	@Override
	public void flush() throws IOException {
		if(i > 0 && col >= 76){
			super.write('\n');
			col = 0;
		}
		if(i == 1){
			super.write(tobase64[(inbuf[0] & 0xFC) >> 2]);
			super.write(tobase64[((inbuf[0] & 0x03) << 4) | ((inbuf[1] & 0xF0) >> 4)]);
			super.write('=');
			super.write('=');
		}else if(i == 2){
			super.write(tobase64[(inbuf[0] & 0xFC) >> 2]);
			super.write(tobase64[((inbuf[0] & 0x03) << 4) | ((inbuf[1] & 0xF0) >> 4)]);
			super.write(tobase64[(inbuf[1] & 0x0F) << 2]);
			super.write('=');
		}
	}
	public static void main(String[] args) {
		System.out.println(base64Encode("李欣"));
	}
}
