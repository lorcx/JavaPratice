package annotation.custom;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.METHOD;


/**
 * 自定义注解
 * @author dell
 *<p>
 *target 有如下参数：
 * 		TYPE : 注解目标是类、接口
 * 		FIELD: 注解目标是字段
 * 		METHOD:注解目标是方法
 * 		PARAMETER：注解目标是方法的参数
 * 		CONSTRUCTOR：注解目标是构造函数
 * 		LOCAL_VARIABLE：注解目标是局部变量
 * </p>
 * <p>
 * @Retention有如下参数(注解的生命周期)
 * 		RetentionPolicy.SOURCE：注解被编译器丢弃
 * 		RetentionPolicy.CLASS：注解保存在class类当中，被虚拟机忽略
 * 		RetentionPolicy.RUNTIME：注解被保存在class类当中，被虚拟机读取
 * 
 * </p>
 */

@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE})
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomAnnocation {
	String name() default "joke";
	int age() default 123;
}
