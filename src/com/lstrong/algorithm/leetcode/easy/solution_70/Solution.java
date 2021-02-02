package com.lstrong.algorithm.leetcode.easy.solution_70;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/2/1 22:22<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {


    int[] memo;

    public int climbStairs(int n) {
        memo = new int[n + 1];
        return calcWays(n);
    }

    private int calcWays(int n) {

        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        if (memo[n] == 0) {
            memo[n] = calcWays(n - 1) + calcWays(n - 2);
        }

        return memo[n];
    }
}
