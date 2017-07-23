package util;

import org.apache.log4j.Logger;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/**
 * 字符集编码转换类
 * Created by lx on 2015/12/13.
 */
public class CodingUtil {
    private static final Logger log = Logger.getLogger(CodingUtil.class);

    //系统编码
    public static String sysEncoding = System.getProperty("file.encoding");

    /**
     * 转换utf-8
     * @param comment:内容
     * @return
     */
    public static String toUTF8(String comment){
        return convert(comment, "UTF-8", "UTF-8");
    }

    /**
     * 转换gb2312
     * @param comment:内容
     * @return
     */
    public static String toGB2312(String comment){
        return convert(comment,"GB2312","GB2312");
    }


    /**
     * 转换
     * @param comment:内容
     * @param originCodeing :原来的编码
     * @param nowCodeing :现在的编码
     * @return
     */
    public static String convert(String comment,String originCodeing,String nowCodeing){
        byte[] byteUTF8 = comment.getBytes(Charset.forName(originCodeing));
        try {
            return new String(byteUTF8,nowCodeing);
        } catch (UnsupportedEncodingException e) {
           log.error("转换失败：result=\"\" ",e.getCause());
           return "";
        }
    }

    public static void main(String[] args) {
        System.out.println(toUTF8("啊啊"));
        System.out.println(toGB2312("啊啊"));
        System.out.println(sysEncoding);
    }
}
