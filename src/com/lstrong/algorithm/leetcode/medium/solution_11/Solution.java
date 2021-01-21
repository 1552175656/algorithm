package com.lstrong.algorithm.leetcode.medium.solution_11;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/1/20 16:02<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {

    public int maxArea(int[] height) {

        int max = Integer.MIN_VALUE;
        int l = 0;
        int r = height.length - 1;

        while (l < r) {

            max = Math.max(max, (r - l) * Math.min(height[l], height[r]));

            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }

        return max;
    }
}
