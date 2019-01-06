package se;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 10 进制转 16进制以内任意转换
 * @Author: lx
 * @Date: Created in 2019/1/6 0006
 */
public class DecimalDemo {
    public static void main(String[] args) {
        DecimalDemo demo = new DecimalDemo();
        System.out.println(demo.tenConvertSystem(1000, 8));
        System.out.println(demo.tenConvertSystem(1000, 4));
        System.out.println(demo.tenConvertSystem(1000, 16));
        System.out.println(demo.tenConvertSystem(1000, 2));
        System.out.println(demo.tenConvertSystem(1000, 3));
    }

    /**
     * 10进制转成任意进制
     * 用栈临时保存
     * @param num
     * @param system
     * @return
     */
    private String tenConvertSystem(int num, int system) {
        Stack<String> stack = new Stack<>();
        while (num > 0) {
            String numStr = getNumber(num, system);
            stack.push(numStr);
            num = num / system;
        }

        StringBuilder builder = new StringBuilder();
        while (!stack.empty()) {
            builder.append(stack.pop());
        }
        return builder.toString();
    }

    private String getNumber(int num, int system) {
        Map<Integer, String> hexMap = new HashMap<>();
        hexMap.put(10, "A");
        hexMap.put(11, "B");
        hexMap.put(12, "C");
        hexMap.put(13, "D");
        hexMap.put(14, "E");
        hexMap.put(15, "F");

        int n = num % system;
        if (system > 10 && n >= 10) {
            return hexMap.get(n);
        }
        return n + "";
    }
}
