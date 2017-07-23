package annotation;

import java.lang.Override;import java.lang.String;import java.lang.System;public class AOverride {

	public static void main(String[] args) {
		AOverride t = new AOverride(); // 实例化类，生成t对象
		System.out.println(t); // 输出该对象
	}

	@Override
	public String toString() {
		return "@Override的使用"; // 调用toString方法
	}

}
