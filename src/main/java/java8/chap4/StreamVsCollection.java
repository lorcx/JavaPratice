package java8.chap4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by x on 2016/12/14.
 */
public class StreamVsCollection {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Java8", "Lambdas", "In", "Action");
        Stream<String> s = names.stream();
        s.forEach(System.out::println);
    }
}
