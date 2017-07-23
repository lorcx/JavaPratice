package design_model.visitor; 
/** 
 * @Description: 
 * @Create on: 2015-2-28 上午09:57:40
 * @Author:李欣
 * @Version:1.0
 */
public interface Subject {
	
	public void accept(Visitor visitor);
	
	public String getSubject();
	
}
 