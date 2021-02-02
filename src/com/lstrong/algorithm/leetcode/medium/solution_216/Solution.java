package com.lstrong.algorithm.leetcode.medium.solution_216;

import java.util.ArrayList;
import java.util.List;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/2/1 11:52<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> path = new ArrayList<>();
        dfs(k, n, 1, path);
        return res;
    }

    private void dfs(int k, int n, int start, List<Integer> path) {
        if (k == path.size() && n == 0) {
            res.add(new ArrayList<>(path));
            return;
        }


        for (int i = start; i <= 9; i++) {

            if (n - i < 0) {
                break;
            }

            path.add(i);
            dfs(k, n - i, i + 1, path);
            path.remove(path.size() - 1);
        }

    }


}
