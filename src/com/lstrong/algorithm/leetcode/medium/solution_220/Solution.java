package com.lstrong.algorithm.leetcode.medium.solution_220;

import java.util.TreeSet;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/1/23 16:12<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Integer ceil = treeSet.ceiling(nums[i]);
            if (ceil != null && ceil <= (long)nums[i] + (long) t) {
                return true;
            }

            Integer floor = treeSet.floor(nums[i]);
            if (floor != null && (long)nums[i] <= (long)t + floor) {
                return true;
            }
            treeSet.add(nums[i]);

            if (treeSet.size() > k) {
                treeSet.remove(nums[i - k]);
            }
        }

        return false;
    }
}
