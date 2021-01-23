package com.lstrong.algorithm.leetcode.medium.solution_49;

import java.util.*;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/1/22 22:51<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0){
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>(strs.length / 2);

        for(String s : strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);

            if(!map.containsKey(sortedStr)){
                map.put(sortedStr, new ArrayList<>());
            }
            map.get(sortedStr).add(s);
        }

        return new ArrayList<>(map.values());
    }
}
