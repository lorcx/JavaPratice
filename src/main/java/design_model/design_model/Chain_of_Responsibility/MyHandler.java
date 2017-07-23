package design_model.Chain_of_Responsibility; 
/** 
 * @Description: 
 * @Create on: 2015-2-27 下午04:00:49
 * @Author:李欣
 * @Version:1.0
 */
public class MyHandler extends AbstractHandler implements Handler{
	private String name;
	
	public MyHandler(String name) {
		this.name = name;
	}
	public void operator() {
		System.out.println(name);
		if(getHandler() != null){
			getHandler().operator();
		}
	}

}
 