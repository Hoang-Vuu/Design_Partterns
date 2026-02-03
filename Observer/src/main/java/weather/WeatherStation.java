package weather;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeatherStation extends Thread {

    private final List<WeatherObserver> observers = new ArrayList<>();
    private final Random random = new Random();

    private int temperature;
    private final int MIN_TEMP = -10;
    private final int MAX_TEMP = 40;

    public WeatherStation() {
        // Set an initial random temperature
        this.temperature = random.nextInt(MAX_TEMP - MIN_TEMP + 1) + MIN_TEMP;
    }

    public void registerObserver(WeatherObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(WeatherObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (WeatherObserver obs : observers) {
            obs.update(temperature);
        }
    }

    @Override
    public void run() {
        while (true) {
            // Sleep randomly between 1–5 seconds
            try {
                Thread.sleep((1 + random.nextInt(5)) * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Change temperature by -1, 0, or +1
            int change = random.nextInt(3) - 1;
            temperature += change;

            // Clamp temperature within limits
            if (temperature < MIN_TEMP) temperature = MIN_TEMP;
            if (temperature > MAX_TEMP) temperature = MAX_TEMP;

            // Notify observers about the change
            notifyObservers();
        }
    }
}
