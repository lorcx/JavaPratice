package design_model.proxy.dynamic; 

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/** 
 * @Description: 
 * @Create on: 2015-2-16
 * @Author:
 * @Version:1.0
 */
public class BookFacadeProxy implements InvocationHandler{
	private Object target;
	
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object result = null;
		System.out.println("before...");
		result = method.invoke(target, args);
		System.out.println("after...");
		return result;
	}
	/**
	 * 缁戝畾涓�釜濮旀墭�?硅薄杩斿洖涓�釜浠ｇ悊绫�?	 * @return
	 */
	public Object bind(Object target) {
		this.target = target;
		//瑕佺粦�?氱殑鎺ュ�?
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}
	
	
	

}
 