package jmx;

import com.mchange.v1.cachedstore.CachedStore;

import javax.management.*;
import javax.management.remote.JMXConnectorServer;
import javax.management.remote.JMXConnectorServerFactory;
import javax.management.remote.JMXServiceURL;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * 将hellombean注入到 mbeanserver
 * @Author: lx
 * @Date: Created in 2020/1/26
 */
public class HelloAgent {
    public static void main(String[] args) throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException, IOException {
        //创建一个mbean server用来管理我们的mbean，通常通过mbeanserver来获取我们的信息
        MBeanServer server = ManagementFactory.getPlatformMBeanServer();

        String domainName = "myBean";
        // 为mbean 创建objectName实例
        ObjectName helloName = new ObjectName(domainName + ":name=Helloworld");

        server.registerMBean(new Hello(), helloName);

        //通过rmi连接
        Registry registry = LocateRegistry.createRegistry(1099);
        //构造jmxserverURL
        /**
         * service:jmx 为jmx标准前缀
         * rmi 传输协议
         * jndi/rmi://localhost:1099/jmxrmi jmx connector server的路径
         */
        JMXServiceURL jmxServiceURL = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:1099/jmxrmi");
        //创建JMXConnectorServer
        JMXConnectorServer cs = JMXConnectorServerFactory.newJMXConnectorServer(jmxServiceURL, null, server);
        cs.start();
    }
}
