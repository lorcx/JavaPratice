package java8.chap5;

import java8.chap4.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java8.chap4.Dish.menu;

/**
 * Created by lx on 2016/12/18.
 */
public class Reducing {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 4, 5, 1, 2);
//        int sum = numbers.stream().reduce(0, (a, b) -> a + b);
        int sum = numbers.stream().reduce(0, (a, b) -> {
            System.out.println(a + "=" + b);
            return a + b;
        });

        System.out.println(sum);

        int sum2 = numbers.stream().reduce(0 , Integer::max);
        System.out.println(sum2);

        System.out.println("----------------------------------");
//        int max = numbers.stream().reduce(0, (a, b) -> Integer.max(a, b));
        int max = numbers.stream().reduce(0, (a, b) -> {
            System.out.println(a + "==" + b);
            return Integer.max(a, b);
        });
        System.out.println(max);

        Optional<Integer> min = numbers.stream().reduce(Integer::min);
        min.ifPresent(System.out::println);

        int calories = menu.stream()
                .map(Dish::getCalories)
                .reduce(0, Integer::sum);
        System.out.println("Number of calories: " + calories);
    }
}