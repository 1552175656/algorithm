package com.lstrong.algorithm.leetcode.medium.solution_150;

import java.util.Stack;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/1/27 16:16<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens.length == 1){
            return Integer.parseInt(tokens[0]);
        }
        int res = 0;
        Stack<String> stack = new Stack<>();
        for (String s : tokens) {
            if (!s.equals("+") && !s.equals("-") && !s.equals("*") && !s.equals("/")) {
                stack.push(s);
            } else {
                int first = Integer.parseInt(stack.pop());
                int second = Integer.parseInt(stack.pop());

                if (s.equals("+")) {
                    res = first + second;
                    stack.push(String.valueOf(first + second));
                } else if (s.equals("-")) {
                    res = second - first;
                    stack.push(String.valueOf(second - first));
                } else if (s.equals("*")) {
                    res = first * second;
                    stack.push(String.valueOf(first * second));
                } else {
                    res = second / first;
                    stack.push(String.valueOf(second / first));
                }
            }
        }

        return res;
    }
}
