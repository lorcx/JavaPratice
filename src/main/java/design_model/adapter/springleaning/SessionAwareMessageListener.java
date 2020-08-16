package design_model.adapter.springleaning;

/**
 * @author lorcx
 */
public interface SessionAwareMessageListener<M extends Message> {
    /**
     * @param message
     * @param session
     */
    void onMessage(M message, Session session);
}
