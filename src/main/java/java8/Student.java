package java8;

/**
 * Created by lx on 2016/11/26.
 */
public class Student implements Younger, Learner {

    @Override
    public void print() {
        Younger.super.print();
        Learner.super.print();
        Younger.sayHi();
        System.out.println("I am a student!");
    }
}
