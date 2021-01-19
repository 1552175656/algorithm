package com.lstrong.algorithm.leetcode.medium.solution_1011;

import java.util.Arrays;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/1/19 19:53<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {

    public int shipWithinDays(int[] weights, int D) {

        int l = Arrays.stream(weights).max().getAsInt();
        int r = Arrays.stream(weights).sum();

        while(l < r){

            int mid = l + (r - l) / 2;
            if(days(weights,mid) <= D) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private int days(int[] weights, int k){

        int cur = 0, res = 0;
        for(int weight: weights) {
            if(cur + weight <= k) {
                cur += weight;
            } else{
                res ++;
                cur = weight;
            }
        }
        res ++;
        return res;
    }
}

