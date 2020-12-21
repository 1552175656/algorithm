package com.lstrong.algorithm.helper;

import java.util.Random;

public class TestSortHelper {

    private static Random random = new Random();

    private TestSortHelper(){

    }

    public static Integer[] generateRandomIntArr(int bound){
        Integer[] arr = new Integer[bound];

        for (int i = 0; i < bound; i++) {
            arr[i] = random.nextInt(bound);
        }

        return arr;
    }


}
