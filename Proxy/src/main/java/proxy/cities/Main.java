package proxy.cities;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        AccessControlService acs = AccessControlService.getInstance();

        // Users
        User alice = new User("alice");
        User bob = new User("bob");
        User guest = new User("guest");

        // Documents
        library.addUnprotectedDocument(
                "public-001",
                LocalDateTime.now().minusDays(2),
                "This is a public document. Anyone can read it."
        );

        library.addProtectedDocument(
                "secret-007",
                LocalDateTime.now().minusHours(10),
                "Top secret content: launch codes..."
        );

        library.addProtectedDocument(
                "hr-999",
                LocalDateTime.now().minusDays(1),
                "HR notes: salary adjustments..."
        );

        // Permissions
        acs.allow("secret-007", "alice");
        acs.allow("hr-999", "bob");

        // Scenario 1: anyone reads public doc
        readDoc(library, "public-001", guest);

        // Scenario 2: allowed user reads protected doc
        readDoc(library, "secret-007", alice);

        // Scenario 3: denied user reads protected doc
        readDoc(library, "secret-007", bob);

        // Scenario 4: metadata always public
        printMetadata(library, "secret-007");
        printMetadata(library, "public-001");

        // Scenario 5: another protected doc with different permissions
        readDoc(library, "hr-999", alice);
        readDoc(library, "hr-999", bob);
    }

    private static void readDoc(Library library, String id, User user) {
        DocumentAccess doc = library.getById(id);
        System.out.println("\nUser '" + user.getUsername() + "' tries to read doc '" + id + "'");

        try {
            System.out.println("Content: " + doc.getContent(user));
        } catch (AccessDeniedException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    private static void printMetadata(Library library, String id) {
        DocumentAccess doc = library.getById(id);
        System.out.println("\nMetadata for '" + id + "':");
        System.out.println("id=" + doc.getId());
        System.out.println("createdAt=" + doc.getCreationDate());
    }
}