package guava;

import com.google.common.base.CharMatcher;

public class CharMatcherTest {
    public static void main(String[] args) {
        String str = "12312,agg";
        CharMatcher charMatcher = CharMatcher.is('g');
        System.out.println(charMatcher.retainFrom(str));

        CharMatcher charMatcher1 = CharMatcher.is('1');
        CharMatcher charMatcher2 = CharMatcher.is('2');
        CharMatcher charMatcher3 = charMatcher1.or(charMatcher2);
        System.out.println(charMatcher3.retainFrom(str));

        System.out.println(charMatcher.matchesAllOf(str));
        str = "ggg";
        System.out.println(charMatcher.matchesAllOf(str));

        boolean matches = CharMatcher.inRange('a', 'z')
                .or(CharMatcher.inRange('A', 'Z'))
                .matches('K');
        System.out.println(matches);

        String s2 = CharMatcher.inRange('0', '9').removeFrom("abc 123 efg");
        System.out.println(s2);
    }
}
