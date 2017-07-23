package design_model.proxy.shangxuetang;

import java.util.Random;

/**
 * tank̹
 * @author dell
 *
 */
public class Tank implements MoveAble{

	@Override
	public void move() {
		System.out.println("移动.....");
		try { 
			//nextint下次伪随机数
			Thread.sleep(new Random().nextInt(10000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
