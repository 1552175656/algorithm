package com.lstrong.algorithm.leetcode.easy.solution_219;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/1/23 15:35<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[i] == nums[j] && Math.abs(i - j) <= k){
                    return true;
                }
            }
        }


        return false;
    }

    public boolean containsNearbyDuplicate1(int[] nums, int k) {

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i]) && set.size() <= k){
                return true;
            }

            set.add(nums[i]);
            if(set.size() == k + 1){
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

}
