package proxy.cities;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class AccessControlService {

    private static final AccessControlService INSTANCE = new AccessControlService();

    // store allowed pairs (username, docId)
    private final Set<Permission> allowed = new HashSet<>();

    private AccessControlService() {
    }

    public static AccessControlService getInstance() {
        return INSTANCE;
    }

    public boolean isAllowed(String documentId, String username) {
        return allowed.contains(new Permission(username, documentId));
    }

    public void allow(String documentId, String username) {
        allowed.add(new Permission(username, documentId));
    }

    // value object
    private static final class Permission {
        private final String username;
        private final String documentId;

        private Permission(String username, String documentId) {
            this.username = username;
            this.documentId = documentId;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Permission)) return false;
            Permission that = (Permission) o;
            return Objects.equals(username, that.username) &&
                    Objects.equals(documentId, that.documentId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(username, documentId);
        }
    }
}