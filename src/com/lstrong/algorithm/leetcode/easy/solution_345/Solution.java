package com.lstrong.algorithm.leetcode.easy.solution_345;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/1/20 15:50<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {


    //元音 a,e,i,o,u

    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();

        int i = 0;
        int j = chars.length - 1;

        while (i < j) {

            while ((i < j) && isVowel(chars[i])) {
                i++;
            }

            while ((i < j) && isVowel(chars[j])) {
                j--;
            }

            swap(chars, i, j);
            i++;
            j--;

        }

        return new String(chars);
    }

    private boolean isVowel(char s) {
        return s != 'a' && s != 'A' && s != 'e' && s != 'E' && s != 'i' && s != 'I' && s != 'o' && s != 'O' && s != 'u' && s != 'U';
    }

    private void swap(char[] nums, int i, int j) {
        char temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
