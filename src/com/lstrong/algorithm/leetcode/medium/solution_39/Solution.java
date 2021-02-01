package com.lstrong.algorithm.leetcode.medium.solution_39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/1/31 23:25<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {


    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, 0, target, path);
        return res;
    }


    private void dfs(int[] candidates, int begin, int target, List<Integer> path) {

        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }


        for (int i = begin; i < candidates.length; i++) {

            if (target - candidates[i] < 0) {
                break;
            }

            path.add(candidates[i]);
            dfs(candidates, i, target - candidates[i], path);
            path.remove(path.size() - 1);
        }

    }
}
