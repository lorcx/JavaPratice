package design_model.proxy.shangxuetang.moniJDK;

import java.lang.reflect.Method;

public class TimeProxy implements InvokerHandler {
	private Object target;
	public TimeProxy(Object target) {
		this.target = target;
	}
	/**
	 * 方法调用
	 */
	public void invoke(Object obj, Method m) {
		System.out.println("start....");
		try {
			m.invoke(target);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("End....");
		
	}

}
