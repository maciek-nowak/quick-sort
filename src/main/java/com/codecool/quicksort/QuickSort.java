package com.codecool.quicksort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuickSort {

    /**
     * Sorts the given List in place
     * @param toSort the List to sort. Throws an error if its null
     */
    public void sort(List<Integer> toSort) {
        if (toSort == null) {
            throw new IllegalArgumentException();
        }

        quicksort(toSort, 0, toSort.size() - 1);
    }

    private void quicksort(List<Integer> toSort, int start, int end) {
        if (start < end) {
            Integer pivotIndex = this.partition(toSort, start, end);
            quicksort(toSort, start, pivotIndex - 1);
            quicksort(toSort, pivotIndex + 1, end);
        }
    }

    private int partition(List<Integer> toSort, int start, int end) {
        randomizePivot(toSort, start, end);

        Integer pivot = toSort.get(start);
        int m = start;

        for (int k = start + 1; k <= end; k++) {

            if (toSort.get(k) < pivot) {
                m++;
                Integer temp = toSort.get(m);
                toSort.set(m, toSort.get(k));
                toSort.set(k, temp);
            }
        }

        Integer temp = toSort.get(m);
        toSort.set(m, pivot);
        toSort.set(start, temp);

        return m;
    }

    private void randomizePivot(List<Integer> toSort, int start, int end) {
        Random r = new Random();
        int randomIndex = r.nextInt(end - start + 1) + start;

        Integer temp = toSort.get(start);
        toSort.set(start, toSort.get(randomIndex));
        toSort.set(randomIndex, temp);
    }
}
