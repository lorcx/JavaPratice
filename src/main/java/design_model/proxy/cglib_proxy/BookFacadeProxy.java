package design_model.proxy.cglib_proxy; 

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;


/** 
 * @Description: 
 * @Create on: 2015-2-17 上午10:18:41
 * @Author:李欣
 * @Version:1.0
 */
public class BookFacadeProxy implements MethodInterceptor{
	
	private Object target;
	/** 
     * 创建代理对象 
     * @param target 
     * @return 
     */  
	public Object getInstance(Object target){
		this.target = target;
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(this.target.getClass()); 
		 // 回调方法 
		enhancer.setCallback(this);
		return enhancer.create();
	}
	
	public Object intercept(Object obj, Method method, Object[] args,
			MethodProxy Proxy) throws Throwable {
		System.out.println("事物开始");  
		Proxy.invokeSuper(obj, args);
		System.out.println("事物结束");  
		return null;
	}

}
 