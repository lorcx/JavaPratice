package jmx;

import javax.management.*;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.util.Set;

/**
 * @Author: lx
 * @Date: Created in 2020/1/26
 */
public class JMXClient {
    public static void main(String[] args) throws Exception {
        String domainName = "myBean";
        //连接jmx
        JMXServiceURL jmxServiceURL = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:1099/jmxrmi");
        JMXConnector connect = JMXConnectorFactory.connect(jmxServiceURL, null);
        MBeanServerConnection mbsc = connect.getMBeanServerConnection();
        ObjectName objectName = new ObjectName(domainName + ":name=Helloworld");

        //打印 domains
        System.out.println("Domains---------------------------------");
        String[] domains = mbsc.getDomains();
        for (String domain : domains) {
            System.out.println("Domain - " + domain);
        }
        System.out.println();

        //mbean count
        System.out.println("mbean count: " + mbsc.getMBeanCount());

        //process attribute
        System.out.println("process attribute:--------------------------");
        mbsc.setAttribute(objectName, new Attribute("Name", "newName"));
        System.out.println("Name=" + mbsc.getAttribute(objectName, "Name"));

        //invoke via proxy
        System.out.println("invoke via proxy");
        HelloMBean proxy = MBeanServerInvocationHandler.newProxyInstance(mbsc, objectName, HelloMBean.class, false);
        System.out.println(proxy.printHello());
        System.out.println(proxy.printHello("zhangsan"));
        System.out.println();

        //get mbean infomation
        System.out.println("get mbean infomation -----------------------------");
        MBeanInfo info = mbsc.getMBeanInfo(objectName);
        System.out.println("Hello class: " + info.getClassName());
        System.out.println("Hello Attribute:" + info.getAttributes()[0].getName());
        System.out.println("Hello Operation:" + info.getOperations()[0].getName());

        //objectName of Mbean
        System.out.println("objectName of Mbean");
        Set<ObjectInstance> set = mbsc.queryMBeans(null, null);
        for (ObjectInstance instance : set) {
            System.out.println(instance.getObjectName());
        }

        connect.close();
    }
}
