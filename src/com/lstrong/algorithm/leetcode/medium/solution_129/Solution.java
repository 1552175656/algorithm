package com.lstrong.algorithm.leetcode.medium.solution_129;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/1/30 16:17<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {

    public int sum = 0;

    public int sumNumbers(TreeNode root) {

        StringBuilder path = new StringBuilder();
        dfs(root, path);
        return sum;
    }


    private void dfs(TreeNode node, StringBuilder path) {
        if (node == null) {
            return;
        }

        path.append(node.val);
        if (node.left == null && node.right == null) {
            System.out.println(path.toString());
            sum += Integer.parseInt(path.toString());
        }

        dfs(node.left, path);
        dfs(node.right, path);
        path.deleteCharAt(path.length() - 1);
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
