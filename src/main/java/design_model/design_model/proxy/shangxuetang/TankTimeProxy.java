package design_model.proxy.shangxuetang;
/**
 * 坦克时间代理类
 * @author dell
 *
 */
public class TankTimeProxy implements MoveAble{
	MoveAble able;
	public TankTimeProxy(MoveAble able) {
		this.able = able;
	}

	public void move() {
		long start = System.currentTimeMillis();
		System.out.println(start);
		able.move();
		long end = System.currentTimeMillis();
		System.out.println(end);
		System.out.println("用时:"+(end-start));
	}

}
