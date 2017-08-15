package design_model.visitor; 
/** 
 * @Description: 
 * @Create on: 2015-2-28 上午10:24:39
 * @Author:李欣
 * @Version:1.0
 */
public class MySubject implements Subject{

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	public String getSubject() {
		
		return "love";
	}

}
 