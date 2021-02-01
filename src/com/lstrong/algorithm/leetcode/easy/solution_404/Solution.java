package com.lstrong.algorithm.leetcode.easy.solution_404;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/1/30 10:36<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {



    public int sumOfLeftLeaves(TreeNode root) {
        int res = 0;
        if (root == null) {
            return 0;
        }

        if(root.left != null){
            if (root.left.left == null && root.left.right == null) {
                res += root.left.val;
            }else {
                res += sumOfLeftLeaves(root.left);
            }
        }

        if (root.right != null) {
            if (root.right.left != null || root.right.right != null) {
                res += sumOfLeftLeaves(root.right);
            }
        }


        return res;
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
