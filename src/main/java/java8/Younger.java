package java8;

/**
 * Created by lx on 2016/11/26.
 */
public interface Younger {
    default void print() {
        System.out.println("I am a youger.");
    }

    static void sayHi() {
        System.out.println("Young is the capital.");
    }
}
