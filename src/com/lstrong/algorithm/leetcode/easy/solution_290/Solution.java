package com.lstrong.algorithm.leetcode.easy.solution_290;

import java.util.HashMap;
import java.util.Map;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/1/21 17:24<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {

    public boolean wordPattern(String pattern, String s) {
        char[] chars = pattern.toCharArray();
        String[] strings = s.split(" ");
        if(chars.length != strings.length){
            return false;
        }
        Map<Character, String> map1 = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();

        for (int i = 0; i < chars.length; i++) {
            if (map1.containsKey(chars[i]) && !strings[i].equals(map1.get(chars[i]))) {
                return false;
            }

            if (map2.containsKey(strings[i]) && chars[i] != map2.get(strings[i])) {
                return false;
            }

            map1.put(chars[i], strings[i]);
            map2.put(strings[i], chars[i]);
        }
        return true;
    }
}
