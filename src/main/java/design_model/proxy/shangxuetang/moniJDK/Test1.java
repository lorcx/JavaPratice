package design_model.proxy.shangxuetang.moniJDK;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.omg.CORBA.portable.InvokeHandler;
import design_model.proxy.shangxuetang.MoveAble;
import design_model.proxy.shangxuetang.TankLogProxy;

public class Test1 {
	 String name;
	 InvokeHandler handler;
	 
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method[] methods = TankLogProxy.class.getMethods();
		for (Method m : methods) {
			System.out.println(m);
		}
		System.out.println(MoveAble.class.getSimpleName());
		
		Method m = TankLogProxy.class.getMethod("move", null);
		System.out.println("111"+m.getName());
		
		Class c = InvokeHandler.class;
		
		InvokeHandler h = null ;
		Constructor ctr = c.getConstructor(InvokeHandler.class);
		Object able = ctr.newInstance(h.getClass());	
	}
}
