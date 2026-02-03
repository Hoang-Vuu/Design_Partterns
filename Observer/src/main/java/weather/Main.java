package weather;

public class Main {
    public static void main(String[] args) {

        WeatherStation station = new WeatherStation();
        station.start(); // Start the weather station thread

        // Create observers
        ConsoleObserver obs1 = new ConsoleObserver("Observer 1");
        ConsoleObserver obs2 = new ConsoleObserver("Observer 2");
        ConsoleObserver obs3 = new ConsoleObserver("Observer 3");

        // Register observers
        station.registerObserver(obs1);
        station.registerObserver(obs2);
        station.registerObserver(obs3);

        // Let simulation run for 10 seconds
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n--- Removing Observer 2 ---\n");
        station.removeObserver(obs2);

        // Continue simulation for another 10 seconds
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nSimulation ended.");
        System.exit(0);
    }
}
