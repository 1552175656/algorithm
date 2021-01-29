package com.lstrong.algorithm.leetcode.easy.solution_100;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/1/29 19:05<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {


        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
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
