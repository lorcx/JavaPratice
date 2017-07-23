package java8;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Lambda 表达式
 * <p>
 * parameter -> expression body
 * <p>
 * 可选的类型声明：你不用去声明参数的类型。编译器可以从参数的值来推断它是什么类型。
 * 可选的参数周围的括号：你可以不用在括号内声明单个参数。但是对于很多参数的情况，括号是必需的。
 * 可选的大括号：如果表达式体里面只有一个语句，那么你不必用大括号括起来。
 * 可选的返回关键字：如果表达式体只有单个表达式用于值的返回，那么编译器会自动完成这一步。
 * 若要指示表达式来返回某个值，则需要使用大括号。
 * <p>
 * <p>
 * Created by lx on 2016/11/26.
 */
public class NewFeaturesTester {
    final static String salutation = "Hello ";

    public static void main(String[] args) {
        NewFeaturesTester tester = new NewFeaturesTester();

        // 带有类型声明的表达式
        MathOperation addition = (int a, int b) -> a + b;

        // 没有类型声明的表达式
        MathOperation subtraction = (a, b) -> a - b;

        //带有大括号、带有返回语句的表达式
        MathOperation multiplication1 = (int a, int b) -> {
            a += 100;
            b += 50;
            return a * b;
        };

        MathOperation multiplication2 = (int a, int b) -> a * b;

        //没有大括号和return语句的表达式
        MathOperation division = (int a, int b) -> a / b;

        //结果
        System.out.println("10 + 5 = " + tester.operate(100, 2, addition));
        System.out.println("10 - 5 = " + tester.operate(100, 2, subtraction));
        System.out.println("10 * 5 = " + tester.operate(100, 2, multiplication1));
        System.out.println("10 * 5 = " + tester.operate(100, 2, multiplication2));
        System.out.println("10 / 5 = " + tester.operate(100, 2, division));

        // 没有括号的表达式
        GreatingService greatingService = m -> System.out.println("Hello " + m);
        greatingService.sayMessage("world");

        // 有括号的表达式
        GreatingService greatingService2 = (message) -> System.out.println("hello " + message);
        greatingService2.sayMessage("lx");

        /**********************************作用域*********************************************/
        GreatingService greetService3 = message -> {
//            salutation = "1"; error
            System.out.println(salutation + message);
        };
        greetService3.sayMessage("world");

        /**********************************方法引用*********************************************/
        List names = new ArrayList();
        names.add("Peters");
        names.add("Linda");
        names.add("Smith");
        names.add("Zack");
        names.add("Bob");

        // 通过System.out :: println 引用了输出的方法
        names.forEach(System.out::println);

        System.out.println("旧的foreach");
        for (Object name : names) {
            System.out.println(name);
        }

        String abc1 = String.valueOf("aaaaa");

//        () -> this.toString();
//        () -> new String();

        /********************************函数式接口****************************************/
        List<Integer> list = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println("All of the numbers");
        eval(list, n -> false);

        System.out.println("Even numbers:");
        eval(list, n -> n % 2 == 0);

        System.out.println("Numbers that greater than 5:");
        eval(list, n -> n > 5);

        Younger younger = new Student();
        younger.print();

        /****************************Optional***********************************************/
        NewFeaturesTester tester4 = new NewFeaturesTester();
        Integer value1 = null;
        Integer values2 = new Integer(5);

        // ofNullable 允许传参给出null
        Optional<Integer> a = Optional.ofNullable(value1);

        // 如果传入的参数为null, 那么of 将抛出nullpointerexception
        Optional<Integer> b = Optional.of(values2);
        System.out.println(tester.sum(a, b));
        /****************************streams***********************************************/
        // limit 减少stream 大小
        Random random = new Random();
//        random.ints().limit(10).forEach(System.out::println);


        // map 将每个元素映射到对应的结果上
        List<Integer> numbers = Arrays.asList(2, 3, 4, 5, 6, 7, 8);
        List<Integer> squaresList = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
//        squaresList.forEach(System.out::print);

        // filter 用于过滤满足条件的元素
        List<String> strings = Arrays.asList("efg", "", "abc", "bc", "ghij", "lmn");
        int count = (int) strings.stream().filter(string -> string.isEmpty()).count();
        System.out.println("过滤空字符串的数量 ：" + count);

        // sorted 对stream 进行排序
        Random random3 = new Random();
//        random3.ints().limit(10).sorted().forEach(System.out::println);

        /******并行处理*****/
        List<String> strings2 = Arrays.asList("efg", "", "abc", "bc", "ghij", "lmn");
        int count2 = (int) strings2.parallelStream().filter(string -> strings.isEmpty()).count();
        System.out.println(count2);

        // collector
        List<String> strings3 = Arrays.asList("efg", "", "abc", "bc", "ghij", "lmn");
        List<String> filted = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println("Filted List" + filted);

        String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("Merged String " + mergedString);

        /************统计工具****************/
//        List<Integer> numbers = Arrays.asList(2,3,4,5,6,7,8,9);
    }

    public Integer sum(Optional<Integer> a, Optional<Integer> b) {
        // isPresent 用于检查是否存在
        System.out.println("First paramter is presetn: " + a.isPresent());
        System.out.println("Second paramter is presetn: " + b.isPresent());
        // 如果当前返回的是传入的默认值，orElse 将返回它
        Integer value1 = a.orElse(new Integer(0));

        // get 用于获得值，条件是这个值必须存在
        Integer value2 = b.get();
        return value1 + value2;
    }

    public static void eval(List<Integer> list, Predicate<Integer> predicate) {
        for (Integer n : list) {
//            System.out.println(predicate.test(n));
            if (predicate.test(n)) {
                System.out.println(n + " ");
            }
        }
    }

    private static void testStatic() {

    }

    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }
}
