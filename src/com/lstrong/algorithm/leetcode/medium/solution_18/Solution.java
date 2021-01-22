package com.lstrong.algorithm.leetcode.medium.solution_18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/1/22 17:22<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < nums.length - 3; i++) {
            if(nums[i] > target){
                break;
            }
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }

            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if (nums[i] + nums[length - 3] + nums[length - 2] + nums[length - 1] < target) {
                continue;
            }

            for (int j = i + 1; j < nums.length - 2; j++) {
                if(j > i + 1 && nums[j] == nums[j - 1]){
                    continue;
                }

                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if (nums[i] + nums[j] + nums[length - 2] + nums[length - 1] < target) {
                    continue;
                }

                int k = j + 1, m = nums.length - 1;
                while (k < m){
                    int sum = nums[i] + nums[j] + nums[k] + nums[m];
                    if(sum == target){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add(nums[m]);
                        res.add(list);
                        while (k < m && nums[k] == nums[k + 1]){
                            k++;
                        }
                        while (k < m && nums[m] == nums[m - 1]){
                            m--;
                        }
                        k++;
                        m--;
                    }else if(sum > target){
                        m--;
                    }else {
                        k++;
                    }
                }
            }
        }


        return res;
    }
}
