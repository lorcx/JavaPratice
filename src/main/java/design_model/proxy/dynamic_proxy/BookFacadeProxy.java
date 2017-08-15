package design_model.proxy.dynamic_proxy; 

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/** 
 * @Description: 
 * @Create on: 2015-2-16 下午05:04:28
 * @Author:李欣
 * @Version:1.0
 */
public class BookFacadeProxy implements InvocationHandler{
	private Object target;
	
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object result = null;//局部变量需要先初始化
		System.out.println("事物的调用之前");
		result = method.invoke(target, args);
		System.out.println("事物的调用之后");
		return result;
	}
	/**
	 * 绑定一个委托对象返回一个代理类
	 * @return
	 */
	public Object bind(Object target) {
		this.target = target;
		//要绑定的接口
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}
	
	
	

}
 