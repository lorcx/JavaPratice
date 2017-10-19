package review;

import java.util.*;

/**
 * Comparable 和 Comparator
 * Created by lx on 2017/10/13.
 */
public class Student implements Comparable<Student> {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Student o) {
        return this.age - o.age;
    }

    @Override
    public String toString() {
        return "[name=" + this.name + ",age=" + this.age + "]";
    }
}

class Test01 {
    public static void main(String[] args) {
        Set<Student> set = new TreeSet<>();
        set.add(new Student("a", 1));
        set.add(new Student("b", 2));
        set.add(new Student("c", 3));
        set.forEach(System.out::println);

    }
}

class Student2 {
    private String name;
    private int age;

    public Student2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "[name=" + this.name + ",age=" + this.age + "]";
    }
}

class Test02 {
    public static void main(String[] args) {
        List<Student2> list = new ArrayList<>();
        list.add(new Student2("a", 1));
        list.add(new Student2("b", 2));
        list.add(new Student2("c", 3));
        Collections.sort(list, (Student2 s1, Student2 s2) -> s1.getAge() - s2.getAge());
        list.forEach(System.out::println);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}