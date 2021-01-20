package com.lstrong.algorithm.leetcode.easy.solution_283;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/1/19 11:25<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {


    public void moveZeroes1(int[] nums) {
        int[] temp = new int[nums.length];

        int index = 0;
        for (int num : nums) {
            if (num != 0) {
                temp[index] = num;
                index++;
            }
        }

        System.arraycopy(temp, 0, nums, 0, nums.length);

    }

    public void moveZeroes2(int[] nums) {

        //[0, k)为非零元素。
        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[k] = nums[i];
                k++;
            }
        }

        for (int i = k; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public void moveZeroes3(int[] nums) {

        //[0, k)为非零元素。
        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if(i != k) {
                    swap(nums, k, i);
                }
                k++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
