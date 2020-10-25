package guava;

import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.List;

public class ComparisonChainTest {
    static class Person implements Comparable<Person>{
        private String lastName;
        private int zipCode;
        private String firstName;

        @Override
        public int compareTo(Person o) {
            return ComparisonChain.start()
                    .compare(this.lastName, o.lastName)
                    .result();
        }

        public Person(String lastName, int zipCode, String firstName) {
            this.lastName = lastName;
            this.zipCode = zipCode;
            this.firstName = firstName;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "lastName='" + lastName + '\'' +
                    ", zipCode=" + zipCode +
                    ", firstName='" + firstName + '\'' +
                    '}';
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public int getZipCode() {
            return zipCode;
        }

        public void setZipCode(int zipCode) {
            this.zipCode = zipCode;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }
    }

    public static void main(String[] args) {
        Person p1 = new Person("last1", 1, "fasdf");
        Person p2 = new Person("last3", 2, "fasdf");
        Person p3 = new Person("last2", 2, "fasdf");
        List<Person> list = Lists.newArrayList(p1, p2, p3);
        Collections.sort(list);

        System.out.println(list);
    }
}
