package proxy.cities;

import java.time.LocalDateTime;

public class DocumentProxy implements DocumentAccess {

    private final Document realDocument; // chỉ proxy giữ reference này
    private final AccessControlService acs;

    public DocumentProxy(Document realDocument) {
        this.realDocument = realDocument;
        this.acs = AccessControlService.getInstance();
    }

    @Override
    public String getId() {
        return realDocument.getId();
    }

    @Override
    public LocalDateTime getCreationDate() {
        return realDocument.getCreationDate();
    }

    @Override
    public String getContent(User user) {
        String username = (user == null) ? null : user.getUsername();
        if (username != null && acs.isAllowed(getId(), username)) {
            return realDocument.getContent();
        }
        throw new AccessDeniedException(
                "Access denied for user='" + username + "' to document id='" + getId() + "'"
        );
    }
}