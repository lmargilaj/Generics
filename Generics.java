import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Generics<T extends Comparable<T>> {
    public static void main(String[] args) {
        // ArrayList of integers
        List<Integer> numList = new ArrayList<>(Arrays.asList(4, 7, 9, 2, 8));

        // ArrayList that will be used for both sorting algos
        List<Integer> bubbleSortList = new ArrayList<>(numList);
        List<Integer> mergeSortList = new ArrayList<>(numList);

        // Performs Bubble Sort
        bubbleSort(bubbleSortList);

        // Performs Merge Sort
        mergeSort(mergeSortList);

        System.out.println("Unsorted List: " + numList);
        System.out.println("Merge Sorted List: " + mergeSortList);
        System.out.println("Bubble Sorted List: " + bubbleSortList);
    }

    public static <T extends Comparable<T>> void mergeSort(List<T> list) {
        if (list.size() <= 1) {
            return;
        }

        // Split the list into two halves
        int mid = list.size() / 2;
        List<T> left = new ArrayList<>(list.subList(0, mid));
        List<T> right = new ArrayList<>(list.subList(mid, list.size()));

        // Recursively sort the two halves
        mergeSort(left);
        mergeSort(right);

        // Merge the sorted halves
        merge(list, left, right);
    }

    private static <T extends Comparable<T>> void merge(List<T> result, List<T> left, List<T> right) {
        int i = 0, j = 0, k = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i).compareTo(right.get(j)) < 0) {
                result.set(k++, left.get(i++));
            } else {
                result.set(k++, right.get(j++));
            }
        }

        while (i < left.size()) {
            result.set(k++, left.get(i++));
        }

        while (j < right.size()) {
            result.set(k++, right.get(j++));
        }
    }

    public static <T extends Comparable<T>> void bubbleSort(List<T> list) {
        int n = list.size();
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (list.get(i - 1).compareTo(list.get(i)) > 0) {
                    // Swap the elements
                    T temp = list.get(i - 1);
                    list.set(i - 1, list.get(i));
                    list.set(i, temp);
                    swapped = true;
                }
            }
            n--;
        } while (swapped);
    }
}
