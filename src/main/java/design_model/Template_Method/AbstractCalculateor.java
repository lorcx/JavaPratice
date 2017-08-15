package design_model.Template_Method; 
/** 
 * @Description: 抽象的计算器
 * @Create on: 2015-2-27 上午10:30:48
 * @Author:李欣
 * @Version:1.0
 */
public abstract class AbstractCalculateor {
	/**
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
	/**
	 * 主方法
	 * @param exp
	 * @param opt
	 * @return
	 */
	public final int calculate(String exp,String opt){
		int[] arrayInt = split(exp,opt);
		return calculate(arrayInt[0],arrayInt[1]);
	}
	/**
	 * 抽象计算方法
	 * @param num1
	 * @param num2
	 * @return
	 */
	public abstract int calculate(int num1,int num2);
	
}
 