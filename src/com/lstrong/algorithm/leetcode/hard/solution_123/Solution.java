package com.lstrong.algorithm.leetcode.hard.solution_123;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/2/3 13:21<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int max_k = 2;
        int n = prices.length;
        int[][][] dp = new int[n][max_k + 1][2];
        dp[0][1][0] = 0;
        dp[0][1][1] = -prices[0];
        dp[0][2][0] = 0;
        dp[0][2][1] = -prices[0];
        for (int i = 0; i < n; i++) {
            for (int k = max_k; k >= 1; k--) {
                if (i - 1 == -1) {
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i])
                ;
            }
        }
        return dp[n - 1][max_k][0];
    }
}
