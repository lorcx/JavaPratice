package cglib_study;

import cglib_study.proxy.AuthProxy;

/**
 * 仅供客户端调用
 * Created by lx on 2017/6/3.
 */
public class Client {

    public static void main(String[] args) {
        Client c = new Client();
        c.anyOneCanManager();
        c.haveAuthManager("mary");
        c.haveAuthManager("jim");
        c.selectivityAuthManager("mary");
        c.selectivityAuthManager("jim");
    }

    /**
     * 模拟：没有权限的会员，可以进行查询
     * @param loginName
     */
    private void selectivityAuthManager(String loginName) {
        System.out.println("the loginer's name is " + loginName);
        InfoManager manager = InfoManagerFactory.getSelectivityAuthInstance(new AuthProxy(loginName));
        doCRUD(manager);
        separatorLine();
    }

    /**
     * 模拟：有权限的会员操作
     * @param loginName
     */
    private void haveAuthManager(String loginName) {
        System.out.println("the loginer's name is " + loginName);
        InfoManager manager = InfoManagerFactory.getAuthInstance(new AuthProxy(loginName));
        doCRUD(manager);
        separatorLine();
    }

    /**
     * 模拟：没有任何权限要求，任何人都可以操作
     * Retrieve 查
     */
    private void anyOneCanManager() {
        System.out.println("any one can do manager");
        InfoManager manager = InfoManagerFactory.getInstance();
        doCRUD(manager);
        separatorLine();
    }

    /**
     * 分割线
     */
    private void separatorLine() {
        System.out.println("------------------------------------");
    }

    /**
     * 模拟增删改查操作
     * @param manager
     */
    private void doCRUD(InfoManager manager) {
        manager.create();
        manager.query();
        manager.update();
        manager.delete();
    }


}
