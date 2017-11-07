package se;

import java.util.Hashtable;
import java.util.Map;

public class HashTableStudent {
    public static void main(String[] args) {
        Map map = new Hashtable();
        map.put("key", "value");
        System.out.println(map.get("key"));

        map.put("key", null);
        System.out.println(map.get("key"));// NPE
    }

}
