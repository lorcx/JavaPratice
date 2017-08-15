package design_model.proxy.shangxuetang;
/**
 * 将上一次的代理对象作为被代理的对象
 * @author dell
 *
 */
public class Test {
	public static void main(String[] args) {
		TankLogProxy tlp = new TankLogProxy(new Tank());
		TankTimeProxy ttp = new TankTimeProxy(tlp);
		ttp.move();
		
	}
}
