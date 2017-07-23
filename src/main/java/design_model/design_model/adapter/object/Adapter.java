package design_model.adapter.object; 
/** 
 * @Description: shipeiqi lei
 * @Create on: 2015-2-26 下午02:38:12
 * @Author:李欣
 * @Version:1.0
 */
public class Adapter implements TargetAble {
	private Source source;
	public Adapter(Source source) {
		this.source = source;
	}

	public void Method2() {
         System.out.println("this is the targetable method!"); 
	}

	public void Method1() {
		source.Method1();
	}
	
}
 