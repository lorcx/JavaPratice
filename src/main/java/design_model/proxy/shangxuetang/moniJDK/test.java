package design_model.proxy.shangxuetang.moniJDK;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import design_model.proxy.shangxuetang.MoveAble;
import design_model.proxy.shangxuetang.Tank;

public class test {
	/**
	 * 将源码动态编译
	 * @param args
	 */
	public static void main(String[] args) {
		
		/*  1.拿到源码       */
		//widow下的回车加换行
		String rt = "\r\n";
		String str = "package design_model.proxy.shangxuetang;"+rt+
					 "public class TankLogProxy1 implements MoveAble{"+rt+
				     "private MoveAble able;"+rt+
					 "public TankLogProxy1(MoveAble able) {"+rt+
				     "this.able = able;"+rt+
					 "}"+rt+
				     "public void move() {"+rt+
					 "System.out.println(\"start....\");"+rt+
				     "able.move();"+rt+
					 "System.out.println(\"end...\");"+rt+
				     "}"+rt+
				     "}";
		/*------------生成.java文件-------------------*/
		String fileName = System.getProperty("user.dir")+"/src/design_model.design_model/proxy/shangxuetang/TankLogProxy1.java";
		File file = new File(fileName);
		try {
			FileWriter fw = new FileWriter(file);
			fw.write(str);
			fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/*  compiler 编译*/
		
		//获取java编译器 就是javac
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		//打印类的名字
		System.out.println(compiler.getClass().getName());
		// null 是使用默认的
		StandardJavaFileManager filemsg = compiler.getStandardFileManager(null, null, null);
		//Iterable 简单理解是个数组
		Iterable units = filemsg.getJavaFileObjects(fileName);
		CompilationTask task  = compiler.getTask(null, filemsg, null, null, null, units);
		//编译
		task.call();
		try {
			filemsg.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		/*load into memory and create an instance*/
		try {
			URL[] urls = new URL[]{new URL("file:/"+System.getProperty("user.dir")+"/src")};
			URLClassLoader ul = new URLClassLoader(urls);
			Class c = ul.loadClass("design_model.proxy.shangxuetang.TankLogProxy1");
			System.out.println(c);
			
			//创建对象
		 Constructor ctr = c.getConstructor(MoveAble.class);
		 MoveAble able = (MoveAble) ctr.newInstance(new Tank());	
		 able.move(); 
		
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
	}
}
