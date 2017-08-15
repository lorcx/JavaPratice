package design_model.decorator; 
/** 
 * @Description: 
 * @Create on: 2015-2-26 下午03:55:31
 * @Author:李欣
 * @Version:1.0
 */
public class decoratorTest {
	public static void main(String[] args) {
		SourceAble able = new Source1();
		decorator decorator = new decorator(able);
		decorator.method();
	}
}
 