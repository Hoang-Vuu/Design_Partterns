package chain_of_responsibility.customer_feedback;

public class CompensationClaimHandler extends FeedbackHandler {

    @Override
    public void handle(FeedbackMessage message) {
        if (message.getType() == FeedbackType.COMPENSATION_CLAIM) {
            System.out.println("[CompensationClaimHandler] Received claim from: " + message.getSenderEmail());
            System.out.println("Content: " + message.getContent());

            // Demo logic: approve if content length looks detailed enough
            boolean approved = message.getContent() != null && message.getContent().length() >= 30;

            if (approved) {
                System.out.println("Result: Claim APPROVED (will issue compensation).");
            } else {
                System.out.println("Result: Claim REJECTED (insufficient details).");
            }
            return;
        }

        System.out.println("[CompensationClaimHandler] Not my type. Passing to next handler...");
        super.handle(message);
    }
}