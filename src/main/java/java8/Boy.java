package java8;

/**
 * Created by lx on 2016/11/26.
 */
public interface Boy {
    default void print() {
        System.out.println("I am a boy.");
    }
}
