package chain_of_responsibility.customer_feedback;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Build chain (same style as travel_expenses)
        FeedbackHandler compensation = new CompensationClaimHandler();
        FeedbackHandler contact = new ContactRequestHandler();
        FeedbackHandler dev = new DevelopmentSuggestionHandler();
        FeedbackHandler general = new GeneralFeedbackHandler();

        compensation.setNext(contact);
        contact.setNext(dev);
        dev.setNext(general);

        FeedbackHandler primaryHandler = compensation;

        // Generate test messages
        List<FeedbackMessage> messages = new ArrayList<>();
        messages.add(new FeedbackMessage(
                FeedbackType.COMPENSATION_CLAIM,
                "My order arrived damaged and I have photos. Please refund or compensate me.",
                "alice@example.com"
        ));
        messages.add(new FeedbackMessage(
                FeedbackType.COMPENSATION_CLAIM,
                "Broken item.",
                "bob@example.com"
        ));
        messages.add(new FeedbackMessage(
                FeedbackType.CONTACT_REQUEST,
                "Please call me about invoice #INV-1024. Best time: 2-4pm.",
                "carol@example.com"
        ));
        messages.add(new FeedbackMessage(
                FeedbackType.DEVELOPMENT_SUGGESTION,
                "Feature request: add dark mode and improve performance on older phones.",
                "dave@example.com"
        ));
        messages.add(new FeedbackMessage(
                FeedbackType.GENERAL_FEEDBACK,
                "Great service, fast shipping. Thank you!",
                "erin@example.com"
        ));

        // Process each feedback through the chain
        for (FeedbackMessage msg : messages) {
            System.out.println("\n--- New Feedback Message ---");
            System.out.println("Type=" + msg.getType() + ", From=" + msg.getSenderEmail());
            primaryHandler.handle(msg);
        }
    }
}