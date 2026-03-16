package proxy.cities;

import java.time.LocalDateTime;

public interface DocumentAccess {
    String getId();
    LocalDateTime getCreationDate();

    // Nội dung có thể bị bảo vệ -> proxy sẽ kiểm tra quyền
    String getContent(User user);
}