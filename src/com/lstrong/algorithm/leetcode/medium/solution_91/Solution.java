package com.lstrong.algorithm.leetcode.medium.solution_91;

import java.util.Arrays;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/2/2 14:34<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {


    int[] memo;

    //记忆化递归
    public int numDecodingsR(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }
        memo = new int[s.length() + 1];
        Arrays.fill(memo, -1);
        return dfs(s, 0);
    }

    private int dfs(String s, int index) {


        if (index == s.length()) {
            return 1;
        }


        if (s.charAt(index) == '0') {
            return 0;
        }

        if (memo[index] != -1) {
            return memo[index];
        }

        int res1 = dfs(s, index + 1);
        int res2 = 0;
        if (index < s.length() - 1 && isIn(s, index, index + 1)) {
            res2 = dfs(s, index + 2);
        }

        memo[index] = res1 + res2;
        return res1 + res2;
    }

    private boolean isIn(String s, int begin, int end) {
        int number = Integer.parseInt(s.substring(begin, end + 1));
        return number >= 10 && number <= 26;
    }

    //dp
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }
        int len = s.length();

        int[] dp = new int[len];
        char[] chars = s.toCharArray();
        dp[0] = 1;

        for (int i = 1; i < len; i++) {
            if (chars[i] != '0') {
                dp[i] = dp[i - 1];
            }

            int num = (chars[i - 1] - '0') * 10 + (chars[i] - '0');
            if (num >= 10 && num <= 26) {
                if (i == 1) {
                    dp[i]++;
                } else {
                    dp[i] += dp[i - 2];
                }
            }
        }

        return dp[len - 1];
    }



    public static void main(String[] args) {
        int res = new Solution().numDecodings("27");
        System.out.println(res);
    }
}
