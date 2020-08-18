package design_model.adapter.springleaning;

/**
 * @author lorcx
 */
public class MessageListenerAdapter extends AbstractAdaptableMessageListener
        implements SubscriptionNameProvider {
    private Object delegate;

    public MessageListenerAdapter() {
        this.delegate = this;
    }

    public MessageListenerAdapter(Object delegate) {
        this.delegate = delegate;
    }

    @Override
    public String getSubscriptionName() {
        return null;
    }

    @Override
    public void onMessage(Message message, Session session) {
        System.out.println("MessageListenerAdapter onMessage ==>>");

        Object delegate = getDelegate();
        if (delegate != this) {
            if (delegate instanceof SessionAwareMessageListener) {
                System.out.println("匹配到 SessionAwareMessageListener");
                ((SessionAwareMessageListener<Message>) delegate).onMessage(message, session);
            }

            if (delegate instanceof MessageListener) {
                System.out.println("匹配到 MessageListeer");
                ((MessageListener) delegate).onMessage(message);
            }
        }

        // 实现是本身 ...................
    }

    protected Object getDelegate() {
        return this.delegate;
    }
}
