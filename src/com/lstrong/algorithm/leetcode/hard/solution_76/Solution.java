package com.lstrong.algorithm.leetcode.hard.solution_76;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/1/21 13:57<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {

    public String minWindow(String s, String t) {
        String result = "";
        int l = 0, r = t.length() - 1;
        int min = s.length() + 1;

        while (l <= s.length() - t.length()){

            if(r < s.length() && s.substring(l, r + 1).contains(t)){
                if(min > (r - l + 1)){
                    result = s.substring(l, r + 1);
                    min = r - l + 1;
                }
            }

        }

        return result;
    }


    private static boolean contains(String s, String t){

        int[] count = new int[52];
        for(char c : s.toCharArray()){
            count[c-'A']++;
        }


        for(char c : t.toCharArray()){
            count[c-'A']--;
            if(count[c-'A'] < 0){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        System.out.println(contains("BANC", "ABC"));
    }
}
