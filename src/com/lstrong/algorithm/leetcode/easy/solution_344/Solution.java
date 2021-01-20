package com.lstrong.algorithm.leetcode.easy.solution_344;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/1/20 15:47<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {

    public void reverseString(char[] s) {
        int len = s.length;

        for (int i = 0; i < len / 2; i++) {
            swap(s, i, len - i - 1);
        }

    }

    private void swap(char[] nums, int i, int j) {
        char temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
