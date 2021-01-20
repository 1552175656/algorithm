package com.lstrong.algorithm.leetcode.easy.solution_125;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/1/20 15:16<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {

    public boolean isPalindrome(String s) {
        if (s == null || s.equals("")) {
            return true;
        }

        char[] chars = s.toLowerCase().toCharArray();
        int i = 0;
        int j = chars.length - 1;

        while (i < j) {

            while ((i < j) && !Character.isLetterOrDigit(chars[i])) {
                i++;
            }

            while ((i < j) && !Character.isLetterOrDigit(chars[j])) {
                j--;
            }

            if(chars[i] != chars[j]){
                return false;
            }

            i++;
            j--;
        }

        return true;
    }

}
