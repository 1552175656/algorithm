package com.lstrong.algorithm.leetcode.easy.solution_167;

import java.util.HashMap;
import java.util.Map;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/1/20 14:40<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {

    public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {


                return new int[]{map.get(target - nums[i]) + 1, i + 1};
            }
            map.put(nums[i], i);
        }

        return new int[0];
    }


    public int[] twoSum(int[] nums, int target) {
        int i = 0, j = nums.length - 1;

        while (i < j) {

            if (nums[i] + nums[j] == target) {
                return new int[]{i + 1, j + 1};
            } else if (nums[i] + nums[j] < target) {
                i++;
            } else {
                j--;
            }

        }

        return new int[0];
    }
}
