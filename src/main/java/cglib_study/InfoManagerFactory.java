package cglib_study;

import cglib_study.proxy.AuthProxy;
import cglib_study.proxy.AuthProxyFilter;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

/**
 * 工厂类
 * Created by lx on 2017/6/3.
 */
public class InfoManagerFactory {
    private static InfoManager manager = new InfoManager();

    /**
     * 创建原始的InfoManager
     * @return
     */
    public static InfoManager getInstance() {
        return manager;
    }

    /**
     * 创建带有权限校验的InfoManager
     * @return
     */
    public static InfoManager getAuthInstance(AuthProxy proxy) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(InfoManager.class);
        enhancer.setCallback(proxy);
        return (InfoManager) enhancer.create();
    }

    /**
     * 创建不同权限的的infoManger
     * @param auth
     * @return
     */
    public static InfoManager getSelectivityAuthInstance(AuthProxy auth) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(InfoManager.class);
        enhancer.setCallbacks(new Callback[]{auth, NoOp.INSTANCE});
        enhancer.setCallbackFilter(new AuthProxyFilter());
        return (InfoManager) enhancer.create();
    }

}
