package com.lstrong.algorithm.leetcode.medium.solution_47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/1/31 22:01<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {


    List<List<Integer>> res = new ArrayList<>();
    boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        used = new boolean[nums.length];
        List<Integer> path = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, 0, path);
        return res;
    }

    private void dfs(int[] nums, int index, List<Integer> path) {
        if (index == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
                continue;
            }

            path.add(nums[i]);
            used[i] = true;
            dfs(nums, index + 1, path);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }

}


