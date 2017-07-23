package java8;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.UUID;

/**
 * Created by lx on 2016/11/27.
 */
public class Base64Tester {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String base64encodedString = Base64.getEncoder().encodeToString("shiyanlou.com".getBytes("utf-8"));
        System.out.println("basic base64 encoding "  + base64encodedString);

        //解码
        byte[] base64decodedBytes = Base64.getDecoder().decode(base64encodedString);
        System.out.println("解码" + new String(base64decodedBytes, "utf-8"));

        base64encodedString = Base64.getUrlEncoder().encodeToString("shiyanlou.com".getBytes("utf-8"));
        System.out.println("Url base64 encoding" + base64encodedString);

        // mime 类型的base64编码
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            stringBuilder.append(UUID.randomUUID().toString());
        }

        byte[] mimeBytes = stringBuilder.toString().getBytes("utf-8");
        String mimeEncodedString = Base64.getMimeEncoder().encodeToString(mimeBytes);
        System.out.println("mime" + mimeEncodedString);


    }
}
