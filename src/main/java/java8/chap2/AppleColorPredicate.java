package java8.chap2;

import java8.chap1.Apple;

/**
 * Created by lx on 2016/12/4.
 */
public class AppleColorPredicate implements ApplePredicate {

    @Override
    public boolean test(Apple a) {
        return "green".equals(a.getColor());
    }
}
