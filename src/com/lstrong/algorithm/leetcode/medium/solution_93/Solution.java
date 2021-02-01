package com.lstrong.algorithm.leetcode.medium.solution_93;

import java.util.ArrayList;
import java.util.List;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/1/31 15:37<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {

    List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        List<String> path = new ArrayList<>();
        dfs(s, 0, 0, s.length(), path);
        return res;
    }

    void dfs(String s, int index, int depth, int length, List<String> path) {
        if (index == length && depth == 4) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < path.size(); i++) {
                builder.append(path.get(i));
                if(i < path.size() - 1){
                    builder.append(".");
                }
            }
            res.add(builder.toString());
            return;
        }

        if (depth == 4) {
            return;
        }
        for (int i = index; i < length; i++) {
            String sub = s.substring(index, i + 1);
            if (sub.length() > 1 && sub.charAt(0) == '0') {
                break;
            }
            if (Integer.parseInt(sub) > 255) {
                break;
            }
            path.add(sub);
            dfs(s, i + 1, depth + 1, length, path);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        new Solution().restoreIpAddresses("25525511135");
    }
}
