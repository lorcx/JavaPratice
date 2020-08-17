package jdkapi.java_lang;

public class ByteTest {
    public static void main(String[] args) {
        byte a = 127;
        System.out.println(Byte.toString(a));

        String s = "0x12";
        System.out.println(Byte.decode(s));
    }
}
