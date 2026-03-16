package chain_of_responsibility.customer_feedback;

public class DevelopmentSuggestionHandler extends FeedbackHandler {

    @Override
    public void handle(FeedbackMessage message) {
        if (message.getType() == FeedbackType.DEVELOPMENT_SUGGESTION) {
            System.out.println("[DevelopmentSuggestionHandler] Suggestion from: " + message.getSenderEmail());
            System.out.println("Content: " + message.getContent());

            // Demo: "log and prioritize"
            int priority = estimatePriority(message.getContent());
            System.out.println("Result: Logged. Priority = " + priority + " (higher means more urgent).");
            return;
        }

        System.out.println("[DevelopmentSuggestionHandler] Not my type. Passing to next handler...");
        super.handle(message);
    }

    private int estimatePriority(String content) {
        if (content == null) return 1;
        String c = content.toLowerCase();

        if (c.contains("security") || c.contains("crash") || c.contains("data loss")) return 5;
        if (c.contains("slow") || c.contains("performance")) return 4;
        if (c.contains("feature") || c.contains("add")) return 3;
        return 2;
    }
}