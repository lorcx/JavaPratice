package design_model.prototype; 
/** 
 * @Description: 
 * @Create on: 2015-2-26 下午01:57:22
 * @Author:李欣
 * @Version:1.0
 */
public class Prototype implements Cloneable{
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Prototype prot = (Prototype) super.clone();//重点
		return prot;
	}
}
 