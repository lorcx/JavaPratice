package design_model.interpreter; 
/** 
 * @Description:表达式 
 * @Create on: 2015-2-28 上午11:22:50
 * @Author:李欣
 * @Version:1.0
 */
public interface Expression {
	/**
	 * 解析
	 * @return
	 */
	public int interpret(Context context);
}
 