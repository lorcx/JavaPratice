package design_model.adapter.jiekou; 
/** 
 * @Description: 
 * @Create on: 2015-2-26 下午03:19:59
 * @Author:李欣
 * @Version:1.0
 */
public class SourceTest {
	public static void main(String[] args) {
		Source1 source1 = new Source1();
		Source2 source2 = new Source2();
		source1.Method1();
		source1.Method2();
		
	    source2.Method1();
		source2.Method2();
	}
}
 