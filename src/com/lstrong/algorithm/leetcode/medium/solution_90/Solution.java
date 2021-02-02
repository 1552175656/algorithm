package com.lstrong.algorithm.leetcode.medium.solution_90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/2/1 14:24<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, 0, res, subset);
        return res;
    }


    private void dfs(int[] nums, int start, List<List<Integer>> res, List<Integer> subset) {
        res.add(new ArrayList<>(subset));
        for (int i = start; i < nums.length; i++) {

            if(i > start && nums[i] == nums[i - 1]){
                continue;
            }
            subset.add(nums[i]);
            dfs(nums, i + 1, res, subset);
            subset.remove(subset.size() - 1);
        }

    }
}
