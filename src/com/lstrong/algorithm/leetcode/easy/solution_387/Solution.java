package com.lstrong.algorithm.leetcode.easy.solution_387;

import java.util.HashSet;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/1/10 18:08<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {

    public int firstUniqChar(String s) {

        int[] count = new int[26];
        char[] chars = s.toCharArray();

        for (char ch : chars) {
            count[ch - 'a']++;
        }


        for (int i = 0; i < chars.length; i++) {
            if (count[chars[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

}
