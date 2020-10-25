package guava;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;

import java.util.ArrayList;
import java.util.List;

/**
 * 相当于 Map<String, List<?>>
 * 将相同key的value放到一个list里
 */
public class MultimapTest {
    public static void main(String[] args) {
        List<ComparisonChainTest.Person> list = Lists.newArrayList(
                new ComparisonChainTest.Person("l1", 123, "bf"),
                new ComparisonChainTest.Person("l1", 446, "gr"),
                new ComparisonChainTest.Person("l1", 768, "8h"),
                new ComparisonChainTest.Person("l2", 768, "8h")
        );

        Multimap<Object, Object> multimap = ArrayListMultimap.create();
        list.forEach(v->{
            multimap.put(v.getLastName(), v);
        });

        System.out.println(multimap);
    }
}
