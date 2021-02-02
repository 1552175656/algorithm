package com.lstrong.algorithm.leetcode.medium.solution_78;

import java.util.ArrayList;
import java.util.List;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/2/1 12:19<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {


    //迭代
    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());

        for (int num : nums) {
            int size = res.size();
            for (int i = 0; i < size; i++) {
                List<Integer> newSubset = new ArrayList<>(res.get(i));
                newSubset.add(num);
                res.add(newSubset);
            }
        }
        return res;
    }

    //回溯
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        dfs(nums, 0, res, subset);
        return res;
    }

    private void dfs(int[] nums, int start, List<List<Integer>> res, List<Integer> subset) {
        res.add(new ArrayList<>(subset));
        for (int i = start; i < nums.length; i++) {
            subset.add(nums[i]);
            dfs(nums, i + 1, res, subset);
            subset.remove(subset.size() - 1);
        }

    }


}
