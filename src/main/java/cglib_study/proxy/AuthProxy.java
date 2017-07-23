package cglib_study.proxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 权限校验代理类 （cglib）
 * Created by lx on 2017/6/3.
 */
public class AuthProxy implements MethodInterceptor{

    // 会员登录姓名
    private String name;

    public AuthProxy(String name) {
        this.name = name;
    }

    /**
     *  权限校验：
     *  如果会员名字为mary,则有权限做操作，否则提示没有权限
     * @param o
     * @param method
     * @param objects
     * @param methodProxy
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        if (!"mary".equals(name)) {
            System.out.println("Auth Proxy: you have no permits to do manager!");
            return null;
        }
        return proxy.invokeSuper(o, args);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
