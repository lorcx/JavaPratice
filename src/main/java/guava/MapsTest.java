package guava;

import com.google.common.base.Joiner;
import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;

import java.util.Map;

public class MapsTest {
    public static void main(String[] args) {
        Map<Integer, String> maps = Maps.newHashMap();
        maps.put(1, "haha");
        maps.put(2, "bbb");
        String result = Joiner.on("-").withKeyValueSeparator("vvv").join(maps);
        System.out.println(result);

        Map<String, Integer> map1 = Maps.newHashMap();
        map1.put("a", 1);
        map1.put("b", 2);
        map1.put("c", 3);
        map1.put("f", 3);

        Map<String, Integer> map2 = Maps.newHashMap();
        map2.put("b", 20);
        map2.put("c", 3);
        map2.put("d", 4);
        map2.put("f", 5);

        //差集
        MapDifference<String, Integer> difference = Maps.difference(map1, map2);
        System.out.println(difference.entriesInCommon());
        System.out.println(difference.entriesOnlyOnLeft());
        System.out.println(difference.entriesOnlyOnRight());

        System.out.println(difference);
        //key相等 value不相等
        System.out.println(difference.entriesDiffering());
    }
}
