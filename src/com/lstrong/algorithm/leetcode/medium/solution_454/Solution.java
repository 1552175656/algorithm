package com.lstrong.algorithm.leetcode.medium.solution_454;

import java.util.HashMap;
import java.util.Map;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/1/22 22:44<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {


    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : A) {
            for (int b : B) {
                map.put((a + b), map.getOrDefault((a + b), 0) + 1);
            }
        }

        for (int c : C) {
            for (int d : D) {
                if (map.containsKey(-(c + d))) {
                    count += map.get(-(c + d));
                }
            }
        }

        return count;
    }


}
