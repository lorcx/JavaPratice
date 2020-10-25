package guava;

import com.google.common.collect.Sets;

import java.util.Set;

public class SetsTest {
    public static void main(String[] args) {
        Set<Integer> s1 = Sets.newHashSet(1, 2, 3, 4, 5, 6);
        Set<Integer> s2 = Sets.newHashSet(4, 5, 6, 7, 8, 9);
        //并集
        Sets.SetView<Integer> setView = Sets.union(s1, s2);
        System.out.println(setView);

        //差集
        Sets.SetView<Integer> setView1 = Sets.difference(s1, s2);
        System.out.println(setView1);

        //交集
        Sets.SetView<Integer> setView2 = Sets.intersection(s1, s2);
        System.out.println(setView2);
    }
}
