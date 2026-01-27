public class Employee implements OrgComponent {
    private final String name;
    private final double salary;

    public Employee(String name, double salary) {
        this.name   = name;
        this.salary = salary;
    }

    @Override public String getName() { return name; }
    @Override public double totalSalary() { return salary; }

    @Override
    public String toXml(int indent) {
        return indent(indent) + "<employee name=\"" + esc(name) + "\" salary=\"" + salary + "\"/>\n";
    }
}
