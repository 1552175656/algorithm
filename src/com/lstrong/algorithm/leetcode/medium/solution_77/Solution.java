package com.lstrong.algorithm.leetcode.medium.solution_77;

import java.util.ArrayList;
import java.util.List;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/1/31 22:49<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (k <= 0 || k > n) {
            return res;
        }
        List<Integer> path = new ArrayList<>();
        dfs(n, k, 1, path);
        return res;
    }


    private void dfs(int n, int k, int start, List<Integer> path) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            dfs(n, k, i + 1, path);
            path.remove(path.size() - 1);
        }

    }


}
