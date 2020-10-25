package guava;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import sun.java2d.pipe.SpanIterator;
import sun.security.provider.ConfigFile;

import java.util.Spliterator;

public class MultiSetTest {
    public static void main(String[] args) {
        //HashMultimap<String, String> stringStringHashMultimap = new HashMultimap<>();
        Multiset<String> stringSet = HashMultiset.create();
        stringSet.add("abcd");
        stringSet.add("abcd");
        stringSet.add("bbcd");
        stringSet.add("cbcd");
        stringSet.add("sbcd");
        stringSet.add("abcd");
        System.out.println(stringSet);
        System.out.println(stringSet.size());
        System.out.println(stringSet.count("abcd"));
        //System.out.println(stringSet.remove("abcd"));
        //System.out.println(stringSet);
        Spliterator<String> spliterator =
                stringSet.spliterator();
        System.out.println(spliterator.characteristics());
    }
}
