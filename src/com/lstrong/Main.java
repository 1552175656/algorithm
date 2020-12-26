package com.lstrong;

import com.lstrong.algorithm.helper.TestSortHelper;
import com.lstrong.algorithm.sort.QuickSort;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int bound = 10000000;

        Integer[] arr = TestSortHelper.generateRandomIntArr(bound);
        long start = System.nanoTime();

        Arrays.sort(arr);

        long end = System.nanoTime();

        double time = (end - start) / 1000000000.0;

        System.out.println(time);
    }
}
