package java8.chap5;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by x on 2016/12/14.
 */
public class BuildingStreams {
    public static void main(String[] args) throws IOException {
        // stream of
        Stream<String> stream = Stream.of("java8", "Lambdas", "In", "Action");
        stream.map(String::toUpperCase).forEach(System.out::println);

        // Stream.empty
        Stream<String> emptyStream = Stream.empty();
        System.out.println(emptyStream);

        // Arrays.stream
        int[] numbers = {2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.stream(numbers).sum());

        // Straem.iterate 从 0开始每次加2 一共10个数
        Stream.iterate(0, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);

        // fibonnci with iterate
        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(10)
                .forEach(t -> System.out.println("(" + t[0] + ", " + t[1] + ")"));

        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(10)
                .map(t -> t[0])
                .forEach(System.out::println);

        // random stream of doubles with Stream.generate
        Stream.generate(Math::random)
                .limit(10)
                .forEach(System.out::println);

        // 生成5个1
        Stream.generate(() -> 1)
                .limit(5)
                .forEach(System.out::println);

        IntStream.generate(new IntSupplier() {
            @Override
            public int getAsInt() {
                return 2;
            }
        }).limit(5)
            .forEach(System.out::println);

        IntSupplier fib = new IntSupplier() {
            private int previous = 0;
            private int current = 1;
            @Override
            public int getAsInt() {
                int nextValue = this.previous + this.current;
                this.previous = this.current;
                this.current = nextValue;
                return this.previous;
            }
        };

        System.out.println("-------------");
        IntStream.generate(fib).limit(10).forEach(System.out::println);

        long uniqueWords = Files.lines(Paths.get("F:\\idea_repo\\java_300\\src\\java8\\chap5\\data.txt"), Charset.defaultCharset())
                                .flatMap(line -> Arrays.stream(line.split(" ")))
                                .distinct()
                                .count();
        System.out.println("There are " + uniqueWords + " unique words in data.txt");

    }
}
