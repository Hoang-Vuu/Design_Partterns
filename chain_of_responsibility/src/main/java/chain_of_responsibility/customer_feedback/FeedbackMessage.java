package chain_of_responsibility.customer_feedback;

public class FeedbackMessage {
    private final FeedbackType type;
    private final String content;
    private final String senderEmail;

    public FeedbackMessage(FeedbackType type, String content, String senderEmail) {
        this.type = type;
        this.content = content;
        this.senderEmail = senderEmail;
    }

    public FeedbackType getType() {
        return type;
    }

    public String getContent() {
        return content;
    }

    public String getSenderEmail() {
        return senderEmail;
    }
}