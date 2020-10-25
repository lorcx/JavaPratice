package guava;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class BiMapTest {
    public static void main(String[] args) {
        BiMap<String, String> biMap = HashBiMap.create();
        biMap.put("a", "b");
        biMap.put("c", "d");
        System.out.println(biMap);
        System.out.println(biMap.get("a"));
        System.out.println(biMap.inverse().get("b"));

    }
}
