package com.lstrong.algorithm.leetcode.medium.solution_46;

import java.util.ArrayList;
import java.util.List;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/1/31 21:37<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {

    List<List<Integer>> res = new ArrayList<>();
    boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        List<Integer> path = new ArrayList<>();
        dfs(nums, 0, path);
        return res;
    }


    private void dfs(int[] nums, int index, List<Integer> path) {
        if (index == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;
                dfs(nums, index + 1, path);
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }

    }

    public static void main(String[] args) {
        System.out.println(new Solution().permute(new int[]{1, 1, 2}));
    }

}
