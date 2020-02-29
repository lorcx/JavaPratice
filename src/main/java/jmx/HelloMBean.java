package jmx;

/**
 * mbean接口
 * @Author: lx
 * @Date: Created in 2020/1/26
 */
public interface HelloMBean {
    public String getName();

    void setName(String name);

    String printHello();

    String printHello(String whoName);
}
