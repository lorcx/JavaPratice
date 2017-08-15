package design_model.bridge; 
/** 
 * @Description: 
 * @Create on: 2015-2-26 下午04:59:54
 * @Author:李欣
 * @Version:1.0
 */
public abstract class Bridge {
	private Source source;

	public Source getSource() {
		return source;
	}
	/*------------------------------------------------*/
	public void method() {
		getSource().Method1();
	}
	public void setSource(Source source) {
		this.source = source;
	}
}
 