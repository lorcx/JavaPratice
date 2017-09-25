package se;
/**
 * 重写toString 会输出信息
 * @author dell
 *
 */
public class ToString {
	@Override
	public String toString() {
		return "重写了toString方法。。。。";
	}
	
	public static void main(String[] args) {
		ToString to = new ToString();
		System.out.println(to);
	}
}
