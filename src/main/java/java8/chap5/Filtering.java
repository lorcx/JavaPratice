package java8.chap5;

import java8.chap4.Dish;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by x on 2016/12/14.
 */
public class Filtering {
    public static void main(String[] args) {
        // Filtering with predicate
        List<Dish> vegetarianMenu = Dish.menu.stream().filter(Dish::isVegetarian).collect(Collectors.toList());
        vegetarianMenu.forEach(System.out::println);

        // Truncating a stream
        List<Dish> dishesLimit3 = Dish.menu.stream().filter(d -> d.getCalories() > 300).limit(3).collect(Collectors.toList());
        dishesLimit3.forEach(System.out::println);
    }

    private static Collector<? super Dish, Object, Object> toList() {
        return null;
    }
}
