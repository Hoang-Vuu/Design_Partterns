package strategy.sorting;

/*
 * Reference (adapted from GeeksforGeeks):
 * https://www.geeksforgeeks.org/bubble-sort-algorithm/
 * (Modified to fit the Strategy pattern and to sort int[])
 */
public class BubbleSortStrategy implements SortingStrategy {

    @Override
    public void sort(int[] array) {
        int n = array.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    swapped = true;
                }
            }

            // optimization: stop if already sorted
            if (!swapped) break;
        }
    }
}