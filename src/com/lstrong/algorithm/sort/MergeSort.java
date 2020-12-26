package com.lstrong.algorithm.sort;


import java.util.Arrays;

/**
 * @author asus
 */
public class MergeSort {

    private MergeSort() {
    }


    public static <E extends Comparable<E>> void sort(E[] arr) {
        E[] temp = Arrays.copyOfRange(arr, 0, arr.length - 1);
        sort(arr, 0, arr.length - 1, temp);
    }


    public static <E extends Comparable<E>> void sort(E[] arr, int left, int right, E[] temp) {
        if (left > right) {
            return;
        }

        int mid = left + (right - left) / 2;
        sort(arr, left, mid - 1, temp);
        sort(arr, mid + 1, right, temp);
        if (arr[mid].compareTo(arr[mid + 1]) > 0) {
            merge(arr, left, mid, right, temp);
        }
    }

    public static <E extends Comparable<E>> void merge(E[] arr, int left, int mid, int right, E[] temp) {

        System.arraycopy(arr, left, temp, left, right - left + 1);

        int i = left;
        int j = mid + 1;

        for (int k = left; k <= right; k++) {
            if (i > mid) {
                arr[k] = temp[j];
                j++;
            } else if (j > right) {
                arr[k] = temp[i];
                i++;
            }

            if (arr[i].compareTo(arr[j]) <= 0) {
                arr[k] = temp[i];
                i++;
            } else {
                arr[k] = temp[j];
                j++;
            }
        }
    }

    public static <E extends Comparable<E>> void sortBU(E[] arr) {

        E[] temp = Arrays.copyOf(arr, arr.length);

        int n = arr.length;
        for (int sz = 1; sz < n; sz += sz) {
            for (int i = 0; i + sz < n; i += sz + sz) {
                if (arr[i + sz - 1].compareTo(arr[i + sz]) > 0) {
                    merge(arr, i, i + sz - 1, Math.min(i + sz + sz - 1, n - 1), temp);
                }
            }
        }
    }

}
