package guava;

import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;

import java.util.HashSet;
import java.util.Set;

public class Immutable {

    public static void main(String[] args) {
        ImmutableSet<String> set = ImmutableSet.of("red", "orange");
        System.out.println(set);

        Set<String> sets = new HashSet<>();
        sets.add("red");
        sets.add("orange");

        ImmutableSet<Object> set2 = ImmutableSet.builder().addAll(sets).add("blue").build();
        System.out.println(set2);

        Iterable<String> iterable = Iterables.filter(set, Predicates.or(Predicates.equalTo("red")));
        System.out.println(iterable);

    }
}
