package design_model.proxy.shangxuetang.moniJDK;

import org.omg.CORBA.portable.InvokeHandler;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

public class Test1 {
	 String name;
	 InvokeHandler handler;
	 
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		BigDecimal b2 = new BigDecimal(0.1);
		BigDecimal b1 = BigDecimal.valueOf(0.1);
		System.out.println(b1);//0.1
		System.out.println(b2);//0.1000000000000000055511151231257827021181583404541015625
		/*Method[] methods = TankLogProxy.class.getMethods();
		for (Method m : methods) {
			System.out.println(m);
		}
		System.out.println(MoveAble.class.getSimpleName());
		
		Method m = TankLogProxy.class.getMethod("move", null);
		System.out.println("111"+m.getName());
		
		Class c = InvokeHandler.class;
		
		InvokeHandler h = null ;
		Constructor ctr = c.getConstructor(InvokeHandler.class);
		Object able = ctr.newInstance(h.getClass());	*/
	}
}
