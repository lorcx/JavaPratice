package design_model.decorator; 
/** 
 * @Description: 装饰类
 * @Create on: 2015-2-26 下午03:52:34
 * @Author:李欣
 * @Version:1.0
 */
public class decorator implements SourceAble{
	private SourceAble able;
	public decorator(SourceAble able) {
		this.able = able;
	}
	
	public void method() {
		System.out.println("before decorator");
		able.method();
		System.out.println("after decorator");
	}
	
}
 