package review;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by lx on 2017/10/13.
 */
public class FileCopy {
    /**
     * 普通io复制
     * 使用java7特性 TWR
     * @param source
     * @param target
     */
    public static void fileCopyIO(String source, String target) {
        try (InputStream fis = new FileInputStream(source)) {
            try (OutputStream fos = new FileOutputStream(target)) {
                byte[] buffer = new byte[4096];
                int byteToRead;
                while ((byteToRead = fis.read(buffer)) != -1) {
                    fos.write(buffer, 0, byteToRead);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 使用NIO复制
     * 使用java7特性 TWR
     * @param source
     * @param target
     */
    public static void fileCopyNIO(String source, String target) {
        try (FileInputStream fis = new FileInputStream(source)) {
            try (FileOutputStream fos = new FileOutputStream(target)) {
                FileChannel inChannel = fis.getChannel();
                FileChannel outChannel = fos.getChannel();
                ByteBuffer buffer = ByteBuffer.allocate(4096);
                while (inChannel.read(buffer) != -1) {
                    buffer.flip();
                    outChannel.write(buffer);
                    buffer.clear();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        fileCopyIO("f:\\pwd.md","d:\\pwd.md");
        fileCopyNIO("f:\\pwd.md","d:\\pwd.md");
    }
}


