package design_model.visitor; 
/** 
 * @Description: 
 * @Create on: 2015-2-28 上午10:24:50
 * @Author:李欣
 * @Version:1.0
 */
public class MyVisitor implements Visitor{

	public void visit(Subject subject) {
		System.out.println("主题"+subject.getSubject());
	}

}
 