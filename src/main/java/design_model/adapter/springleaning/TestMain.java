package design_model.adapter.springleaning;

public class TestMain {
    public static void main(String[] args) {

        MessageImpl message = new MessageImpl();
        Session session = new SessionImpl();
        SessionAwareMessageListenerImpl awareMessageListener = new SessionAwareMessageListenerImpl();
        MessageListenerAdapter adapter = new MessageListenerAdapter(awareMessageListener);

        //awareMessageListener.onMessage(message, session);
        MessageListener myListener = new MyListener();

        myListener.onMessage(message);

    }

    private static class SessionAwareMessageListenerImpl implements SessionAwareMessageListener<Message>{

        @Override
        public void onMessage(Message message, Session session) {
            System.out.println("SessionAwareMessageListenerImpl >>> 获取到消息");
        }
    }

    private class MessageListenerImpl implements MessageListener {
        @Override
        public void onMessage(Message message) {
            System.out.println("MessageListenerImpl >>> 获取到消息");
        }
    }

}
