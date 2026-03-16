package memento.guistate;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Memento implements IMemento {
    private int[] options;
    private boolean isSelected;

    private final long savedAtMillis;

    public Memento(int[] options, boolean isSelected) {
        this.options = options.clone();
        this.isSelected = isSelected;
        this.savedAtMillis = System.currentTimeMillis();
    }

    public int[] getOptions() {
        return options;
    }

    public boolean isSelected() {
        return isSelected;
    }

    @Override
    public long getSavedAtMillis() {
        return savedAtMillis;
    }

    @Override
    public String getDescription() {
        String time = DateTimeFormatter.ofPattern("HH:mm:ss.SSS")
                .withZone(ZoneId.systemDefault())
                .format(Instant.ofEpochMilli(savedAtMillis));

        return time + " | colors=[" + options[0] + "," + options[1] + "," + options[2] + "] | checked=" + isSelected;
    }

    @Override
    public String toString() {
        return getDescription();
    }
}