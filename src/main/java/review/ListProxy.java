package review;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * jdk动态代理
 * Created by lx on 2017/10/15.
 */
public class ListProxy implements InvocationHandler{
    private List<?> target;

    public ListProxy(List<?> target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("[" + method.getName() + ": " + args[0] + "]");
        Object real = method.invoke(target, args);
        System.out.println("[size=" + target.size() + "]");
        return real;
    }
}

class ProxyTest2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Class<?> clazz = list.getClass();
        ListProxy proxy = new ListProxy(list);
        List<String> proxyList = (List<String>) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), proxy);
        proxyList.add("apple");
        proxyList.add("orange");
        proxyList.add("banana");
        proxyList.remove("banana");
    }
}