package java8.chap2;

import java8.chap1.Apple;

/**
 * Created by lx on 2016/12/4.
 */
public class AppleWeightPredicate implements ApplePredicate{
    @Override
    public boolean test(Apple a) {
        return a.getWeight() > 150;
    }
}
