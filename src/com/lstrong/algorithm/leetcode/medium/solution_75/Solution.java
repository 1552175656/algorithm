package com.lstrong.algorithm.leetcode.medium.solution_75;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2020/12/26 19:08<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {

    public void sortColors(int[] nums) {

        //[0, zero] == 0, [zero + 1, i - 1] == 1, [two, n - 1] == 2
        int zero = -1, i = 0, two = nums.length;
        while (i < two) {

            if (nums[i] == 0) {
                zero++;
                swap(nums, i, zero);
                i++;
            } else if (nums[i] == 2) {
                two--;
                swap(nums, i, two);
            } else {
                i++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public void sortColors1(int[] nums) {

        int[] cnt = new int[3];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                cnt[0]++;
            } else if (nums[i] == 1) {
                cnt[1]++;
            } else {
                cnt[2]++;
            }
        }

        for (int i = 0; i < cnt[0]; i++) {
            nums[i] = 0;
        }

        for (int i = cnt[0]; i < cnt[0] + cnt[1]; i++) {
            nums[i] = 1;
        }

        for (int i = cnt[0] + cnt[1]; i < cnt[0] + cnt[1] + cnt[2]; i++) {
            nums[i] = 2;
        }

    }
}
