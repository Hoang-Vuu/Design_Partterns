public class Organization {
    private final Department root;

    public Organization(String rootDepartmentName) {
        this.root = new Department(rootDepartmentName);
    }

    public Department getRoot() { return root; }

    public void printTotalSalary() {
        System.out.printf("Total salary: %.2f%n", root.totalSalary());
    }
    public void printXml() {
        System.out.print("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        System.out.print(root.toXml(0));
    }
}