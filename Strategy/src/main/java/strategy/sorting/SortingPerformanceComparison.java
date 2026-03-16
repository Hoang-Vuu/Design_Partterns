package strategy.sorting;

import java.util.Arrays;
import java.util.Random;

public class SortingPerformanceComparison {

    public static void main(String[] args) {
        int smallSize = 30;
        int largeSize = 100_000;

        int[] small = createRandomArray(smallSize, 0, 10_000, 42L);
        int[] large = createRandomArray(largeSize, 0, 1_000_000, 42L);

        SortingStrategy[] strategies = new SortingStrategy[] {
                new BubbleSortStrategy(),
                new InsertionSortStrategy(),
                new QuickSortStrategy()
        };

        System.out.println("=== DATASET: SMALL (n=" + smallSize + ") ===");
        runBenchmarks(small, strategies);

        System.out.println();
        System.out.println("=== DATASET: LARGE (n=" + largeSize + ") ===");
        runBenchmarks(large, strategies);

        System.out.println();
        System.out.println("Note: Bubble/Insertion on 100,000 elements can be VERY slow (O(n^2)).");
    }

    private static void runBenchmarks(int[] original, SortingStrategy[] strategies) {
        for (SortingStrategy strategy : strategies) {
            int[] copy = Arrays.copyOf(original, original.length);

            SortContext context = new SortContext(strategy);

            long start = System.nanoTime();
            context.sort(copy);
            long end = System.nanoTime();

            if (!isSorted(copy)) {
                System.out.println(context.strategyName() + " -> FAILED (array not sorted)");
            } else {
                double ms = (end - start) / 1_000_000.0;
                System.out.printf("%-25s : %.3f ms%n", context.strategyName(), ms);
            }
        }
    }

    private static int[] createRandomArray(int size, int minInclusive, int maxExclusive, long seed) {
        Random rnd = new Random(seed);
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rnd.nextInt(maxExclusive - minInclusive) + minInclusive;
        }
        return arr;
    }

    private static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) return false;
        }
        return true;
    }
}