package design_model.proxy.shangxuetang.moniJDK;

import java.lang.reflect.Method;

/**
 * 调用处理
 * 代理逻辑封装类
 * @author dell
 *
 */
public interface InvokerHandler {
	public void invoke(Object obj,Method m);
}
