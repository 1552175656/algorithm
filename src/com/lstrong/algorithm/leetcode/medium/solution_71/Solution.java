package com.lstrong.algorithm.leetcode.medium.solution_71;

import java.util.Arrays;
import java.util.Stack;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/1/27 16:56<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {
    public String simplifyPath(String path) {
        String[] strings = path.split("/");
        Stack<String> stack = new Stack<>();

        for (String s : strings) {
            if (s.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!s.equals("") && !s.equals(".")) {
                stack.push(s);
            }
        }

        if (stack.isEmpty()) {
            return "/";
        }

        StringBuilder res = new StringBuilder();
        for (String s : stack) {
            res.append("/").append(s);
        }

        return res.toString();
    }


    public static void main(String[] args) {
        String[] strings = "/../".split("/");
        System.out.println(strings.length);
        System.out.println(Arrays.toString(strings));
        for (String s : strings) {
            System.out.println(s);
        }

    }
}
