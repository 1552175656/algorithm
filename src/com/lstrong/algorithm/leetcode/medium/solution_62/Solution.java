package com.lstrong.algorithm.leetcode.medium.solution_62;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/2/2 18:35<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }
}
