package com.lstrong.algorithm.leetcode.medium.solution_145;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/1/27 20:53<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Stack<Command> stack = new Stack<>();
        stack.push(new Command("go", root));
        while (!stack.isEmpty()) {
            Command command = stack.pop();
            if ("print".equals(command.s)) {
                res.add(command.node.val);
            } else {
                stack.push(new Command("print", command.node));
                if (command.node.right != null) {
                    stack.push(new Command("go", command.node.right));
                }
                if (command.node.left != null) {
                    stack.push(new Command("go", command.node.left));
                }
            }
        }


        return res;

    }

    public static class Command {
        String s;
        TreeNode node;

        public Command(String s, TreeNode node) {
            this.s = s;
            this.node = node;
        }
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
