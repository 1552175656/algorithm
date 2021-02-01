package com.lstrong.algorithm.leetcode.medium.solution_98;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/1/30 21:59<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {

    //
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode node, long min,long max) {
        if (node == null) {
            return true;
        }

        if (node.val <= min || node.val >= max) {
            return false;
        }

        return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
    }

    //中序递归
    TreeNode prev;
    public boolean isValidBSTR(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (!isValidBSTR(root.left)) {
            return false;
        }

        if (prev != null && prev.val > root.val) {
            return false;
        }

        prev = root;

        return isValidBSTR(root.right);
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
