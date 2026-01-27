import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Department implements OrgComponent {
    private final String name;
    private final List<OrgComponent> children = new ArrayList<>();

    public Department(String name) { this.name = name; }

    @Override public String getName() { return name; }

    @Override public void add(OrgComponent c)    { children.add(c); }
    @Override public void remove(OrgComponent c) { children.remove(c); }

    public List<OrgComponent> getChildren() { return Collections.unmodifiableList(children); }

    @Override
    public double totalSalary() {
        return children.stream().mapToDouble(OrgComponent::totalSalary).sum();
    }

    @Override
    public String toXml(int indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(indent(indent)).append("<department name=\"").append(esc(name)).append("\">\n");
        for (OrgComponent c : children) {
            sb.append(c.toXml(indent + 2));
        }
        sb.append(indent(indent)).append("</department>\n");
        return sb.toString();
    }
}
