package com.lstrong.algorithm.leetcode.easy.solution_101;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/1/29 19:55<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }


        return helper(root, root);
    }

    private boolean helper(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }


        return helper(p.left, q.right) && helper(p.right, q.left);
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
