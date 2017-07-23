package java8.chap5;

import java8.chap4.Dish;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static java8.chap4.Dish.menu;

/**
 * Created by lx on 2016/12/18.
 */
public class Mapping {
    public static void main(String[] args) {
        // map
        List<String> dishNames = menu.stream().map(Dish::getName).collect(toList());
        System.out.println(dishNames);

        // map
        List<String> words = Arrays.asList("Hello", "World");
        List<Integer> wordLengths = words.stream().map(String::length).collect(toList());
        System.out.println(wordLengths);

        // flatMap
        System.out.println("------------------flatMap-----------------");
        words.stream()
                .flatMap((String line) -> Arrays.stream(line.split("")))
                .distinct()
                .forEach(System.out::println);

        System.out.println("------------------map-----------------");
        words.stream()
                .map((String line) -> Arrays.stream(line.split("")))
                .distinct()
                .forEach(System.out::println);

        // flatMap
        List<Integer> number1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> number2 = Arrays.asList(6, 7, 8);
        List<int[]> pairs = number1.stream()
                                    .flatMap((Integer i) -> number2.stream().map((Integer j) -> new int[] {i,j}))
                                    .filter(pair -> (pair[0] + pair[1]) % 3 == 0)
                                    .collect(toList());
        pairs.forEach(pair -> System.out.println("(" + pair[0] + ", " + pair[1] + ")"));
    }
}
