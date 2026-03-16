package chain_of_responsibility.customer_feedback;

public class GeneralFeedbackHandler extends FeedbackHandler {

    @Override
    public void handle(FeedbackMessage message) {
        if (message.getType() == FeedbackType.GENERAL_FEEDBACK) {
            System.out.println("[GeneralFeedbackHandler] General feedback from: " + message.getSenderEmail());
            System.out.println("Content: " + message.getContent());
            System.out.println("Result: Analyzed and responded with a thank-you email (simulated).");
            return;
        }

        // As the last handler, we can also handle "unknown" here instead of passing
        System.out.println("[GeneralFeedbackHandler] Unhandled type: " + message.getType());
        System.out.println("Result: Logged as unknown feedback type.");
    }
}