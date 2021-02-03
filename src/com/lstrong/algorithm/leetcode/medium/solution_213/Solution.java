package com.lstrong.algorithm.leetcode.medium.solution_213;

import java.util.Arrays;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/2/2 20:31<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }

        return Math.max(tryRob(Arrays.copyOfRange(nums, 0, length - 2)),
                tryRob(Arrays.copyOfRange(nums, 1, length - 1)));
    }

    private int tryRob(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        System.out.println(length);
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[length - 1];
    }
}
