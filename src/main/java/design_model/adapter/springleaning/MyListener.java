package design_model.adapter.springleaning;

public class MyListener extends MessageListenerAdapter {
    @Override
    public void onMessage(Message message) {
        System.out.println("MyListener 收到消息");
    }
}
