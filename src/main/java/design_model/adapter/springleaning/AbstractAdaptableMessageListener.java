package design_model.adapter.springleaning;

public abstract class AbstractAdaptableMessageListener
        implements MessageListener, SessionAwareMessageListener<Message> {
    @Override
    public void onMessage(Message message) {
        onMessage(message, null);
    }

    /**
     * @param message
     * @param session
     */
    @Override
    public abstract void onMessage(Message message, Session session);
}
