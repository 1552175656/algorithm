package com.lstrong.algorithm.leetcode.easy.solution_20;

import java.util.Stack;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/1/27 15:52<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();
                char match;
                if (s.charAt(i) == ')') {
                    match = '(';
                } else if (s.charAt(i) == ']') {
                    match = '[';
                } else {
                    match = '{';
                }

                if (top != match) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
