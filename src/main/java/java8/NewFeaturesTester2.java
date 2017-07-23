package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by lx on 2016/11/27.
 */
public class NewFeaturesTester2 {
    public static void main(String[] args) {
        List<String> strings2 = Arrays.asList("efg", "", "abc", "bc", "ghij", "lmn");
        System.out.println("List :" + strings2);

        int count = (int) strings2.stream().filter(string -> string.isEmpty()).count();
        System.out.println(count);

        count = (int) strings2.stream().filter(string -> string.length() == 3).count();
        System.out.println("length == 3 : " + count);

        List<String> filered = strings2.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println("is not empty " + filered);

        String mergedList = strings2.stream().filter(string ->!string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("merged" + mergedList);

        List<Integer> integers = Arrays.asList(1, 2, 4, 5, 6, 7, 8);
        IntSummaryStatistics stats = integers.stream().mapToInt(x -> x).summaryStatistics();
        System.out.println(stats.getMax());
        System.out.println(stats.getMin());
        System.out.println(stats.getSum());
        System.out.println(stats.getAverage());
    }

    /**
     * 使用java 7 计算空字符串的数量
     *
     * @param strings
     * @return
     */
    private static int getCountEmptyStringUsingJava7(List<String> strings) {
        int count = 0;
        for (String str : strings) {
            if (str.isEmpty()) {
                count++;
            }
        }
        return count;
    }

    /**
     * 使用java7来计算3字符的字符串数量
     *
     * @return
     */
    private static int getCountLength3UsingJava7(List<String> strings) {
        int count = 0;
        for (String str : strings) {
            if (str.length() == 3) {
                count++;
            }
        }
        return count;
    }

    /**
     * 使用java7 来删除字符串
     *
     * @param Strings
     * @return
     */
    private static List<String> deleteEmptyStringUsingJava7(List<String> strings) {
        List<String> filteredList = new ArrayList<>();
        for (String str : strings) {
            if (!str.isEmpty()) {
                filteredList.add(str);
            }
        }
        return filteredList;
    }

    /**
     * java 7 合并字符串
     *
     * @param strings
     * @param separator
     * @return
     */
    private static String getMergedStringUsingJava7(List<String> strings, String separator) {
        StringBuilder stringbuiler = new StringBuilder();
        for (String string : strings) {
            if (!string.isEmpty()) {
                stringbuiler.append(string);
                stringbuiler.append(separator);
            }
        }
        String mergedStr = stringbuiler.toString();
        return mergedStr.substring(0, mergedStr.length() - 2);
    }

    // 自定义的用于计算数字的平方的方法
    private static List<Integer> getSquares(List<Integer> numbers) {
        List<Integer> squaresList = new ArrayList<Integer>();

        for (Integer number : numbers) {
            Integer square = new Integer(number.intValue() * number.intValue());

            if (!squaresList.contains(square)) {
                squaresList.add(square);
            }
        }
        return squaresList;
    }

    // 自定义的用于获得List中最大值的方法
    private static int getMax(List<Integer> numbers) {
        int max = numbers.get(0);

        for (int i = 1; i < numbers.size(); i++) {

            Integer number = numbers.get(i);

            if (number.intValue() > max) {
                max = number.intValue();
            }
        }
        return max;
    }

    // 自定义的用于获得List中最小值的方法
    private static int getMin(List<Integer> numbers) {
        int min = numbers.get(0);

        for (int i = 1; i < numbers.size(); i++) {
            Integer number = numbers.get(i);

            if (number.intValue() < min) {
                min = number.intValue();
            }
        }
        return min;
    }

    // 自定义的用于获得List中各个数字的和的方法
    private static int getSum(List<Integer> numbers) {
        int sum = (int) (numbers.get(0));

        for (int i = 1; i < numbers.size(); i++) {
            sum += (int) numbers.get(i);
        }
        return sum;
    }

    // 自定义的用于获得List中各个数字的平均值的方法
    private static int getAverage(List<Integer> numbers) {
        return getSum(numbers) / numbers.size();
    }

}
