package java8.chap2;

import java8.chap1.Apple;

/**
 * Created by lx on 2016/12/4.
 */
public class AppleRedAndHeavyPredicate implements ApplePredicate{

    @Override
    public boolean test(Apple a) {
        return "red".equals(a.getColor()) && a.getWeight() > 150;
    }
}
