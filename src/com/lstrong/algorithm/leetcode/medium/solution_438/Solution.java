package com.lstrong.algorithm.leetcode.medium.solution_438;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/1/21 13:54<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int l = 0, r = p.length() - 1;
        while (l <= s.length() - p.length()) {

            if(r  < s.length() && isAnagram(s.substring(l, r + 1), p)){
                res.add(l);
            }
            l++;
            r++;
        }
        return res;
    }

    private boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        int[] count = new int[26];
        for(char c : s.toCharArray()){
            count[c-'a']++;
        }


        for(char c : t.toCharArray()){
            count[c-'a']--;
            if(count[c-'a'] < 0){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        new Solution().findAnagrams("cbaebabacd", "abc");
    }
}
