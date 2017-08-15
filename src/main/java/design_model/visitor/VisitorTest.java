package design_model.visitor; 
/** 
 * @Description: 
 * @Create on: 2015-2-28 上午10:28:35
 * @Author:李欣
 * @Version:1.0
 */
public class VisitorTest {
	public static void main(String[] args) {
		Subject subject = new MySubject();
		Visitor visitor = new MyVisitor();
		visitor.visit(subject);
		
	}
}
 