package design_model.adapter.object; 
/** 
 * @Description: 对象适配
 * @Create on: 2015-2-26 下午02:42:45
 * @Author:李欣
 * @Version:1.0
 */
public class AdpterTest {
	public static void main(String[] args) {
		Source source = new Source();
		TargetAble able = new Adapter(source);
		able.Method2();
		able.Method1();
	}
}
 