package jdkapi.java_lang;

import sun.security.provider.ConfigFile;

import java.lang.reflect.AnnotatedType;
import java.util.ArrayList;
import java.util.List;

public class ClassTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        System.out.println(Class.forName("java.lang.Thread"));

        Class.forName("jdkapi.java_lang.ClassTest$Inner");
        Class.forName("jdkapi.java_lang.ClassTest$Inner");


        List<String> list = new ArrayList<>();
        Class<? extends ArrayList> x = list.getClass().asSubclass(ArrayList.class);
        ArrayList arrayList = x.newInstance();
        System.out.println(arrayList);
        System.out.println(x);

        Object o = new Object();
        System.out.println(o.getClass().cast(new Object()));


        S f = new S();
        AnnotatedType[] annotatedInterfaces = f.getClass().getAnnotatedInterfaces();
        System.out.println(annotatedInterfaces.length);


        System.out.print(f.getClass().getCanonicalName());

    }

    private static class Inner {
        static {
            System.out.println("初始化");
        }
    }


    @Deprecated
    private static class F{

    }

    private static class S extends F{

    }
}
