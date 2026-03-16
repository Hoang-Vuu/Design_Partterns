package proxy.cities;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Library {

    private final Map<String, DocumentAccess> documents = new HashMap<>();

    public void addUnprotectedDocument(String id, LocalDateTime createdAt, String content) {
        // Unprotected => implement DocumentAccess trực tiếp bằng anonymous class
        documents.put(id, new DocumentAccess() {
            private final String docId = id;
            private final LocalDateTime creationDate = createdAt;
            private final String docContent = content;

            @Override
            public String getId() {
                return docId;
            }

            @Override
            public LocalDateTime getCreationDate() {
                return creationDate;
            }

            @Override
            public String getContent(User user) {
                // no protection
                return docContent;
            }

            @Override
            public String toString() {
                return "UnprotectedDocument{id='" + docId + "', createdAt=" + creationDate + "}";
            }
        });
    }

    public void addProtectedDocument(String id, LocalDateTime createdAt, String content) {
        Document real = new Document(id, createdAt, content);
        DocumentProxy proxy = new DocumentProxy(real);
        documents.put(id, proxy);
    }

    public DocumentAccess getById(String id) {
        return documents.get(id);
    }

    public Map<String, DocumentAccess> getAll() {
        return new HashMap<>(documents);
    }
}