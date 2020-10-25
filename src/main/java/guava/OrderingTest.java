package guava;

import com.google.common.base.Function;
import com.google.common.collect.Ordering;
import org.checkerframework.checker.nullness.qual.Nullable;

public class OrderingTest {
    public static void main(String[] args) {
        Ordering<ComparisonChainTest.Person> ordering = Ordering.natural().nullsFirst().onResultOf(new Function<ComparisonChainTest.Person, String>() {

            @Nullable
            @Override
            public String apply(ComparisonChainTest.@Nullable Person input) {
                return input.getLastName();
            }
        });

        //ordering.compare();
    }
}
