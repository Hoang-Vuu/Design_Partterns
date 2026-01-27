public interface OrgComponent {
    String getName();

    default void add(OrgComponent c) { throw new UnsupportedOperationException("add not supported"); }
    default void remove(OrgComponent c) { throw new UnsupportedOperationException("remove not supported"); }
    double totalSalary();

    String toXml(int indent);

    default String indent(int n) { return " ".repeat(Math.max(0, n)); }
    default String esc(String s) {
        return s == null ? "" : s
                .replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&apos;");
    }
}
