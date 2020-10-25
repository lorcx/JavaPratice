package guava;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

import java.util.ArrayList;

public class ListsTest {
    public static void main(String[] args) {
        ArrayList<String> list = Lists.newArrayList("a", "b", "c", "d", "null");
        String result = Joiner.on("-").join(list);
        System.out.println(result);
        list = Lists.newArrayList("a", "b", "c", "d", "null", null);
        result = Joiner.on("-").skipNulls().join(list);
        System.out.println(result);
        result = Joiner.on("-").useForNull("haha").join(list);
        System.out.println(result);
    }
}
