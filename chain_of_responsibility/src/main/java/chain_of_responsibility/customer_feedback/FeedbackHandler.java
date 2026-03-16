package chain_of_responsibility.customer_feedback;

public abstract class FeedbackHandler {

    private FeedbackHandler next;

    public void setNext(FeedbackHandler next) {
        this.next = next;
    }

    public void handle(FeedbackMessage message) {
        if (next != null) {
            next.handle(message);
        } else {
            System.out.println("No handler found for message type: " + message.getType());
        }
    }
}