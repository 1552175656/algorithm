package com.lstrong.algorithm.leetcode.medium.solution_63;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/2/2 18:53<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];

        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
            dp[i][0] = 1;

        }

        for (int i = 0; i < n && obstacleGrid[0][i] == 0; i++) {

            dp[0][i] = 1;

        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}
