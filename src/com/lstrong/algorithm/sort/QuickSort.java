package com.lstrong.algorithm.sort;

import java.util.Random;

/**
 * @author asus
 */
public class QuickSort {

    private QuickSort() {

    }


    public static <E extends Comparable<E>> void sort(E[] arr) {
        Random random = new Random();
        sort(arr, 0, arr.length - 1, random);
    }

    private static <E extends Comparable<E>> void sort(E[] arr, int left, int right, Random random) {

        if (left >= right) {
            return;
        }

        int p = partition(arr, left, right, random);

        sort(arr, left, p - 1, random);
        sort(arr, p + 1, right, random);
    }

    private static <E extends Comparable<E>> int partition(E[] arr, int left, int right, Random random) {

        int randomIndex = random.nextInt(right - left + 1) + left;
        swap(arr, left, randomIndex);

        int i = left + 1;
        int j = right;

        while (true) {

            while (i <= j && arr[i].compareTo(arr[left]) < 0) {
                i++;
            }

            while (i <= j && arr[j].compareTo(arr[left]) > 0) {
                j--;
            }

            if (i >= j) {
                break;
            }
            swap(arr, i, j);
            i++;
            j--;
        }
        swap(arr, j, left);

        return j;
    }

    private static <E extends Comparable<E>> void sort3ways(E[] arr, int left, int right, Random random) {
        if (left >= right) {
            return;
        }

        int p = left + random.nextInt(right - left + 1);
        swap(arr, p, left);

        //arr[l + 1,lt] < v, arr[lt + 1, i - 1] == v, arr[gt, r] > v
        int lt = left, i = left + 1, gt = right + 1;

        while (i < gt) {

            if (arr[i].compareTo(arr[left]) < 0) {
                lt++;
                swap(arr, i, lt);
                i++;
            } else if (arr[i].compareTo(arr[left]) > 0) {
                gt--;
                swap(arr, i, gt);
            } else {
                i++;
            }
        }
        swap(arr, left, lt);
        //arr[l,lt - 1] < v, arr[lt, gt - 1] == v, arr[gt, r] > v
        sort3ways(arr, left, lt - 1, random);
        sort3ways(arr, gt, right, random);
    }


    private static <E extends Comparable<E>> void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
