package com.lstrong.algorithm.leetcode.easy.solution_205;


import java.util.HashMap;
import java.util.Map;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/1/21 18:32<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        return isIsomorphicHelper(s, t) && isIsomorphicHelper(t, s);
    }

    private boolean isIsomorphicHelper(String s, String t) {
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();

        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < chars1.length; i++) {
            if (map.containsKey(chars1[i]) && chars2[i] != map.get(chars1[i])) {
                return false;
            }
            map.put(chars1[i], chars2[i]);
        }
        return true;
    }
}
