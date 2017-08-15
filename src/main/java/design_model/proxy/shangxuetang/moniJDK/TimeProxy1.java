package design_model.proxy.shangxuetang.moniJDK;
import java.lang.reflect.Method;
import design_model.proxy.shangxuetang.MoveAble;
import design_model.proxy.shangxuetang.moniJDK.InvokerHandler;
public class TimeProxy1 implements MoveAble{
private InvokerHandler handler;
public TimeProxy1(InvokerHandler handler) {
this.handler = handler;
}
@Override
public void move(){
try{
Method md = MoveAble.class.getMethod("move");
handler.invoke(this, md);
}catch (Exception e){e.printStackTrace();}
}
}