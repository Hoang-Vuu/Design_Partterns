package builder.computerbuilder;

public class Main {
    public static void main(String[] args) {
        ComputerBuilder gamingBuilder = new GamingComputerBuilder();
        ComputerDirector director1 = new ComputerDirector(gamingBuilder);
        director1.constructComputer();
        Computer gamingPC = gamingBuilder.getComputer();

        ComputerBuilder officeBuilder = new OfficeComputerBuilder();
        ComputerDirector director2 = new ComputerDirector(officeBuilder);
        director2.constructComputer();
        Computer officePC = officeBuilder.getComputer();

        System.out.println("=== Gaming Computer ===");
        System.out.println(gamingPC);

        System.out.println("=== Office Computer ===");
        System.out.println(officePC);
    }
}