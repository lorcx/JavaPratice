package se;

import java.util.ArrayList;
import java.util.List;

public class ForTest {
    public static void main(String[] args) {
        int size = 10000000;
        long start = System.currentTimeMillis();
        List list = new ArrayList();
        for (int i = 0; i < size; i++) {
//            try {
                list.add(new Object());
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
        }
        long end = System.currentTimeMillis();
        System.out.println(list.size());
        System.out.println((end - start) / 1000 + "s" );
    }
}
