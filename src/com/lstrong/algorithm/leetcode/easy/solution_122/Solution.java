package com.lstrong.algorithm.leetcode.easy.solution_122;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/2/3 13:04<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
        }

        return dp[n - 1][0];
    }
}
