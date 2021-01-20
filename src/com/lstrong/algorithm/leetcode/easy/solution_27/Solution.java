package com.lstrong.algorithm.leetcode.easy.solution_27;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/1/20 10:38<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {

    public int removeElement(int[] nums, int val) {


        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                swap(nums, k, i);
                k++;
            }
        }

        return k;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
