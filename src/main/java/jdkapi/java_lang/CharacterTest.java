package jdkapi.java_lang;

import design_model.bridge.Source;

public class CharacterTest {
    public static void main(String[] args) {
        int i = Character.charCount(100010);
        System.out.println(i);

        int i1 = Character.codePointAt(new char[]{'A', 'B', 'c'}, 2);
        System.out.println(i1);

        System.out.println(Character.codePointAt(new char[]{'a', 'b', 'c'}, 0, 1));
        System.out.println(Character.codePointBefore(new char[]{'a', 'b', 'c'}, 1));

        System.out.println(Character.getDirectionality(10));

        System.out.println(Character.getNumericValue('s'));

        System.out.println(Character.isAlphabetic('1'));
        System.out.println(Character.isAlphabetic('b'));
        System.out.println(Character.isAlphabetic('\t'));
        System.out.println(Character.isAlphabetic('\u0000'));
        System.out.println(Character.isDigit('\u0000'));
        System.out.println(Character.isDigit('0'));

    }
}
