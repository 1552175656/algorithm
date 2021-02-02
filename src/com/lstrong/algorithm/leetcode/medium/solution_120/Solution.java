package com.lstrong.algorithm.leetcode.medium.solution_120;

import java.util.List;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/2/1 22:47<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {

    Integer[][] memo;

    //记忆化递归
    public int minimumTotalR(List<List<Integer>> triangle) {
        memo = new Integer[triangle.size()][triangle.size()];
        return dfs(triangle, 0, 0);
    }

    private int dfs(List<List<Integer>> triangle, int i, int j) {
        if (i == triangle.size()) {
            return 0;
        }

        if (memo[i][j] == null) {
            memo[i][j] = Math.min(dfs(triangle, i + 1, j), dfs(triangle, i + 1, j + 1)) + triangle.get(i).get(j);
        }
        return memo[i][j];
    }

    //动态规划
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }

        return dp[0];
    }
}
