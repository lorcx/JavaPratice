package design_model.proxy.shangxuetang;

public class TankLogProxy implements MoveAble{
	private MoveAble able;
	
	public TankLogProxy(MoveAble able) {
		this.able = able;
	}
	public void move() {
		System.out.println("start....");
		able.move();
		System.out.println("end...");
	}

}
