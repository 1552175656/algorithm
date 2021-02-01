package com.lstrong.algorithm.leetcode.medium.solution_131;

import java.util.ArrayList;
import java.util.List;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/1/31 21:02<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {

    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        List<String> path = new ArrayList<>();
        dfs(s, 0, s.length(), path);
        return res;
    }

    private void dfs(String s, int index, int length, List<String> path) {
        if (index == length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < length; i++) {
            String sub = s.substring(index, i + 1);
            if (!isPalindrome(sub)) {
                continue;
            }
            path.add(sub);
            dfs(s, i + 1, length, path);
            path.remove(path.size() - 1);
        }
    }

    private boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }

        return true;
    }


}
