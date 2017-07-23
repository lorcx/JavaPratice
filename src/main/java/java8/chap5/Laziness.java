package java8.chap5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * limit 每次拿指定个数的匹配项
 * Created by lx on 2016/12/18.
 */
public class Laziness {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> twoEvenSquares = numbers.stream().filter(n -> {
            System.out.println(" filtering " + n);
            return n % 2 == 0;
        }).map(n -> {
            System.out.println("mappting " + n);
            return n * n;
        }).limit(2).collect(Collectors.toList());

        twoEvenSquares.forEach(System.out::println);
    }

}
