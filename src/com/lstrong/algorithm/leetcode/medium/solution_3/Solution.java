package com.lstrong.algorithm.leetcode.medium.solution_3;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/1/21 11:49<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {

    public int lengthOfLongestSubstring(String s) {

        char[] chars = s.toCharArray();
        int l = 0, r = -1;
        int[] freq = new int[256];
        int res = 0;

        while (l < s.length()) {

            if (r + 1 < s.length() && freq[chars[r + 1]] == 0) {
                freq[chars[++r]]++;
            } else {
                freq[chars[l++]]--;
            }

            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}
