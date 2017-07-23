package design_model.proxy.shangxuetang.moniJDK;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import javax.tools.JavaCompiler.CompilationTask;
import org.omg.CORBA.portable.InvokeHandler;
import design_model.proxy.shangxuetang.MoveAble;
import design_model.proxy.shangxuetang.Tank;

@SuppressWarnings("all")
public class Proxy {
	public static Object newProxyInstance(Class inf,InvokerHandler handler)throws Exception{
		//widow下的回车加换行
		String rt = "\r\n";
		String methodStr = "";
		Method[] methods = inf.getMethods();
		for (Method m : methods) {
			/*methodStr += "@Override" + rt +
					     "public void " + m.getName() + "(){" +rt+
						 "System.out.println(\"start....\");"+rt+
					     "able." + m.getName() +"();"+rt+
						 "System.out.println(\"end...\");"+rt+
					     "}";
			*/
			
			methodStr += "@Override" + rt +
				     "public void " + m.getName() + "(){" + rt +
				     "try{" + rt +
				     "Method md = " + inf.getSimpleName() +".class.getMethod(\""+m.getName()+"\");" + rt +
				     "handler.invoke(this, md);"+ rt + 
				     "}catch (Exception e){e.printStackTrace();}" + rt +
				     "}";
		}
		
		
		
		/*  1.拿到源码       */
		
		String str = "package design_model.design_model.proxy.shangxuetang.moniJDK;"+rt+
					 "import java.lang.reflect.Method;" + rt +
					 "import design_model.design_model.proxy.shangxuetang.MoveAble;" + rt +
					 "import design_model.design_model.proxy.shangxuetang.moniJDK.InvokerHandler;" + rt +
					 "public class TimeProxy1 implements "+inf.getSimpleName()+"{"+rt+
				     "private InvokerHandler handler;" + rt +
					 "public TimeProxy1(InvokerHandler handler) {"+rt+
				     "this.handler = handler;"+rt+
					 "}"+rt+
				      methodStr+rt+
				     "}";
		/*------------生成.java文件-------------------*/
		String fileName = System.getProperty("user.dir")+"/src/design_model.design_model/proxy/shangxuetang/moniJDK/TimeProxy1.java";
		File file = new File(fileName);
		FileWriter fw = new FileWriter(file);
		fw.write(str);
		fw.flush();
		fw.close();
		
		/*  compiler 编译*/
		
		//获取java编译器 就是javac
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		//打印类的名字
		//System.out.println(compiler.getClass().getName());
		// null 是使用默认的
		StandardJavaFileManager filemsg = compiler.getStandardFileManager(null, null, null);
		//Iterable 简单理解是个数组
		Iterable units = filemsg.getJavaFileObjects(fileName);
		CompilationTask task  = compiler.getTask(null, filemsg, null, null, null, units);
		//编译
		task.call();
		filemsg.close();
		
		/*load into memory and create an instance*/
		URL[] urls = new URL[]{new URL("file:/"+System.getProperty("user.dir")+"/src")};
		URLClassLoader ul = new URLClassLoader(urls);
		Class c = ul.loadClass("design_model.design_model.proxy.shangxuetang.moniJDK.TimeProxy1");
			
		//创建对象
		Constructor ctr = c.getConstructor(InvokerHandler.class);
		Object able = ctr.newInstance(handler);	
		return able; 
		
	}
}
