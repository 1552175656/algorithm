package com.lstrong.algorithm.leetcode.easy.solution_111;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/1/29 17:53<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {
    public int minDepth(TreeNode root) {


        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int m1 = minDepth(root.left);
        int m2 = minDepth(root.right);

        if (root.right == null || root.left == null) {
            return m1 + m2 + 1;
        }

        return Math.min(m1, m2) + 1;
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
