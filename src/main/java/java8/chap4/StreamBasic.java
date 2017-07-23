package java8.chap4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 *  caloric 卡路里
 * Created by x on 2016/12/13.
 */
public class StreamBasic {
    public static void main(String[] args) {
        getLowCaloricDishesNamesInJava7(Dish.menu).forEach(System.out::println);
        System.out.println("---");
        // java 8
        getLowCaloricDishesNamesInJava8(Dish.menu).forEach(System.out::println);
    }

    private static List<String> getLowCaloricDishesNamesInJava8(List<Dish> menu) {
        return menu.stream()
                .filter(d -> d.getCalories() < 400)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(toList());
    }

    private static List<String> getLowCaloricDishesNamesInJava7(List<Dish> menu) {
        List<Dish> lowCaloricDishes = new ArrayList<>();
        for (Dish d : menu) {
           if (d.getCalories() < 400) {
               lowCaloricDishes.add(d);
           }
        }
        List<String> lowCaloricDishesName = new ArrayList<>();
        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            @Override
            public int compare(Dish d1, Dish d2) {
                return Integer.compare(d1.getCalories(), d2.getCalories());
            }
        });
        for (Dish d : lowCaloricDishes) {
            lowCaloricDishesName.add(d.getName());
        }
        return lowCaloricDishesName;
    }
}
