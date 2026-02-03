public class Main {
    public static void main(String[] args) {
        Organization org = new Organization("Head Office");
        Department root = org.getRoot();

        Department engineering = new Department("Engineering");
        Department sales       = new Department("Sales");
        Department qa          = new Department("QA");

        OrgComponent ceo   = new Employee("CEO", 150_000);
        OrgComponent alice = new Employee("Alice", 95_000);
        OrgComponent bob   = new Employee("Bob",   88_000);
        OrgComponent carol = new Employee("Carol", 70_000);
        OrgComponent dave  = new Employee("Dave",  60_000);
        OrgComponent erin  = new Employee("Erin",  65_000);

        root.add(ceo);
        root.add(engineering);
        root.add(sales);

        engineering.add(alice);
        engineering.add(qa);
        qa.add(dave);
        qa.add(erin);

        sales.add(bob);
        sales.add(carol);
        org.printTotalSalary();
        sales.remove(carol);
        org.printXml();
        org.printTotalSalary();
    }
}