package com.lstrong.algorithm.sort;

/**
 * @author Administrator
 */
public class InsertionSort {

    private InsertionSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {

        for (int i = 0; i < arr.length; i++) {

            E t = arr[i];
            int j;
            for (j = i; j - 1 >= 0 && t.compareTo(arr[j - 1]) < 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = t;
        }
    }


    private static <E extends Comparable<E>> void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
