package com.lstrong.algorithm.sort;

public class SelectionSort {

    private SelectionSort() {

    }

    public static <E extends Comparable<E>> void sort(E[] arr) {

        //arr[0, i)有序， arr[i, n)无序；
        for (int i = 0; i < arr.length; i++) {

            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if(arr[minIndex].compareTo(arr[i]) > 0){
                    minIndex = j;
                }
            }
            swap(arr, minIndex, i);
        }
    }

    private static <E extends Comparable<E>> void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
