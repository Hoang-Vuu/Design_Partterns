package chain_of_responsibility.customer_feedback;

public class ContactRequestHandler extends FeedbackHandler {

    @Override
    public void handle(FeedbackMessage message) {
        if (message.getType() == FeedbackType.CONTACT_REQUEST) {
            System.out.println("[ContactRequestHandler] Contact request from: " + message.getSenderEmail());
            System.out.println("Content: " + message.getContent());
            System.out.println("Result: Forwarded to Customer Support for follow-up.");
            return;
        }

        System.out.println("[ContactRequestHandler] Not my type. Passing to next handler...");
        super.handle(message);
    }
}