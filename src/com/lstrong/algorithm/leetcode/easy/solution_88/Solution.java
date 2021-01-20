package com.lstrong.algorithm.leetcode.easy.solution_88;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/1/20 14:24<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] temp = new int[m + n];
        int i = 0;
        int j = 0;

        for (int k = 0; k < m + n; k++) {
            if (i >= m) {
                temp[k] = nums2[j];
                j++;
            } else if (j >= n) {
                temp[k] = nums1[i];
                i++;
            } else if (nums1[i] > nums2[j]) {
                temp[k] = nums2[j];
                j++;
            } else {
                temp[k] = nums1[i];
                i++;
            }
        }

        System.arraycopy(temp, 0, nums1, 0, m + n);
    }
}
