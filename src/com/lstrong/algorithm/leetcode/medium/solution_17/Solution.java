package com.lstrong.algorithm.leetcode.medium.solution_17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/1/31 12:07<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {
    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {

        if ("".equals(digits)) {
            return res;
        }
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        backTrack(digits, 0, map, new StringBuilder());

        return res;
    }

    private void backTrack(String digits, int index, Map<Character, String> map, StringBuilder builder) {

        if (index == digits.length()) {
            res.add(builder.toString());
            return;
        }

        String s = map.get(digits.charAt(index));
        for (int i = 0; i < s.length(); i++) {
            builder.append(s.charAt(i));
            backTrack(digits, index + 1, map, builder);
            builder.deleteCharAt(builder.length() - 1);
        }
    }

}
