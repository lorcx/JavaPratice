package java8;

/**
 * Created by lx on 2016/11/26.
 */
public interface Learner {
    default void print() {
        System.out.println("I am a learner.");
    }

}
