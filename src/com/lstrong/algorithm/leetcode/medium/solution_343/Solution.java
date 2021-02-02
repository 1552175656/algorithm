package com.lstrong.algorithm.leetcode.medium.solution_343;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/2/2 10:46<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {

    int[] memo;


    //记忆化递归
    public int integerBreakR(int n) {
        memo = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            memo[i] = -1;
        }
        return getMax(n);
    }

    private int getMax(int n) {

        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 1;
        }

        if (memo[n] == -1) {
            for (int i = 1; i <= n - 1; i++) {
                memo[n] = Math.max(i * (n - i), memo[n]);
                memo[n] = Math.max(memo[n], i * getMax(n - i));
            }
        }

        return memo[n];
    }

    //动态规划
    public int integerBreak(int n) {

        int[] dp = new int[n + 1];
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                dp[i] = Math.max(dp[i], j * (i - j));
                dp[i] = Math.max(dp[i], j * dp[i - j]);
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().integerBreak(30));
        ;
    }
}
