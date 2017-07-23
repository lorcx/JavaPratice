package design_model.proxy.shangxuetang.moniJDK;


import design_model.proxy.shangxuetang.MoveAble;
import design_model.proxy.shangxuetang.Tank;

public class ProxyTest {
	public static void main(String[] args) throws Exception {
		
		Tank tank = new Tank();
		InvokerHandler handler = new TimeProxy(tank);
		
		/*第一个参数被代理的接口 第二个自己实现的代理逻辑对象*/
		MoveAble able = (MoveAble) Proxy.newProxyInstance(MoveAble.class,handler);
		able.move();
		
	}
}
