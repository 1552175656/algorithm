package com.lstrong.algorithm.leetcode.easy.solution_26;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/1/20 10:49<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {

    public int removeDuplicates(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int old = nums[0];

        //[0, k)为不重复元素
        int k = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != old) {
                nums[k] = nums[i];
                k++;
                old = nums[i];
            }
        }
        return k;
    }

}
