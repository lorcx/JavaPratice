package cglib_study.proxy;

import net.sf.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

/**
 *  代理过滤
 * Created by lx on 2017/6/3.
 */
public class AuthProxyFilter implements CallbackFilter {

    public static final int AUTH_NEED = 0;
    public static final int AUTH_NOT_NEED = 1;

    /**
     * 如果是query方法所有人都有这个权限
     * @param method
     * @return
     */
    @Override
    public int accept(Method method) {
        if ("query".equals(method.getName())) {
            return AUTH_NOT_NEED;
        }
        return AUTH_NEED;
    }

}
