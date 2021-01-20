package com.lstrong.algorithm.leetcode.medium.solution_80;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/1/20 12:43<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {

    public int removeDuplicates(int[] nums) {
        return helper(nums, 2);
    }


    private int helper(int[] nums, int k) {

        if (nums == null) {
            return 0;
        }

        if (nums.length <= k) {
            return nums.length;
        }

        //[0, index]为满足条件的区间
        int index = k - 1;
        for (int i = k; i < nums.length; i++) {

            //指针移动条件
            // 如果当前数 不 等于 index 前面 k - 1 位置的数， 说明 [index - k + 1, index] 这个区间（长度为k）没有和当前数相等的数，
            // 就满足了 重复的数 出现次数 不超过k次， 那就可以继续添加。 这里也可以反过来考虑，假如相等的话， 由于数组有序性，[index - k + 1,  index]  区间的数 都是相等的， 就超过k次了
            if (nums[i] != nums[index - k + 1]) {
                index++;
                nums[index] = nums[i];
            }
        }

        return index + 1;
    }
}
