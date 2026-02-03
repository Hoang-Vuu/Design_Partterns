package weather;

public class ConsoleObserver implements WeatherObserver {

    private final String name;

    public ConsoleObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(int temperature) {
        System.out.println("[" + name + "] notified: Current temperature = " + temperature + "°C");
    }
}
