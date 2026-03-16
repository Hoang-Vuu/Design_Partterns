package proxy.cities;

import java.time.LocalDateTime;

class Document { // package-private để giảm nguy cơ truy cập trực tiếp từ ngoài package
    private final String id;
    private final LocalDateTime creationDate;
    private final String content;

    Document(String id, LocalDateTime creationDate, String content) {
        this.id = id;
        this.creationDate = creationDate;
        this.content = content;
    }

    String getId() {
        return id;
    }

    LocalDateTime getCreationDate() {
        return creationDate;
    }

    String getContent() {
        return content;
    }
}