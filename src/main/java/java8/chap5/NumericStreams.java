package java8.chap5;

import java8.chap4.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java8.chap4.Dish.menu;

/**
 * Created by lx on 2016/12/18.
 */
public class NumericStreams {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 4, 5, 6, 7);
        // arrays stream
        Arrays.stream(numbers.toArray()).forEach(System.out::println);
        int calories = menu.stream().mapToInt(Dish::getCalories).sum();
        System.out.println("Number of calories :" + calories);

        // max and OptionalInt
        OptionalInt maxCalories = menu.stream()
                .mapToInt(Dish::getCalories)
                .max();
        int max;
        if (maxCalories.isPresent()) {
            max = maxCalories.getAsInt();
        } else {
            // we can choose a default value 默认值
            max = 1;
        }
        System.out.println(max);

        // numberic ranges
        IntStream evenNubmers = IntStream.rangeClosed(1, 100).filter(n -> n % 2 == 0);
        System.out.println(evenNubmers.count());

        Stream<int[]> pythagoreanTriiples =
                IntStream.rangeClosed(1, 100).boxed()
                    .flatMap(a -> IntStream.rangeClosed(a, 100)
                            .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                            .boxed()
                            .map(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)}));
        pythagoreanTriiples.forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));



    }
}
