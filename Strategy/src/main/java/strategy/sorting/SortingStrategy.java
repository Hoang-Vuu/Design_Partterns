package strategy.sorting;

public interface SortingStrategy {
    void sort(int[] array);

    default String name() {
        return this.getClass().getSimpleName();
    }
}