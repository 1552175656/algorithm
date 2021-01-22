package com.lstrong.algorithm.leetcode.medium.solution_16;

import java.util.Arrays;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/1/22 17:52<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {

    public static int threeSumClosest(int[] nums, int target) {
        int best = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1, k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    return sum;
                }

                if (Math.abs(sum - target) < Math.abs(best - target)) {
                    best = sum;
                }

                if (sum > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return best;
    }

    public static void main(String[] args) {
        int[] a = new int[]{-1, 2, 1, -4};
        threeSumClosest(a, 1);
    }
}
