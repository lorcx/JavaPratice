package design_model.strategy; 
/** 
 * @Description: 抽象的计算器
 * @Create on: 2015-2-27 上午10:30:48
 * @Author:李欣
 * @Version:1.0
 */
public abstract class AbstractCalculateor {
	/**辅助类
	 * opt选择
	 * exp函数 经验
	 * @param exp
	 * @param opt
	 * @return
	 */
	public int[] split(String exp,String opt){
		String[] str = exp.split(opt);
		int[] arrayInt = new int[2];
		arrayInt[0] = Integer.parseInt(str[0]);
		arrayInt[1] = Integer.parseInt(str[1]);
		return arrayInt;
	}
}
 