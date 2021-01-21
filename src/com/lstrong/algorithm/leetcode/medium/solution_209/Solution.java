package com.lstrong.algorithm.leetcode.medium.solution_209;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/1/21 10:38<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {

    public int minSubArrayLen(int s, int[] nums) {

        //[l, r]为滑动窗口
        int l = 0, r = -1;
        int sum = 0;
        int res = nums.length + 1;

        while (l < nums.length) {

            if (r + 1 < nums.length && sum < s) {
                sum += nums[++r];
            } else {
                sum -= nums[l++];
            }

            if (sum >= s) {
                res = Math.min(res, r - l + 1);
            }
        }
        if (res == nums.length + 1) {
            return 0;
        }
        return res;
    }

}
