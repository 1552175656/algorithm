package com.lstrong.algorithm.leetcode.medium.solution_230;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/1/30 22:57<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {

    int res;
    int num = 0;

    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return res;
    }

    private void dfs(TreeNode node, int k) {

        if (node == null) {
            return;
        }

        dfs(node.left, k);

        num++;
        if (k == num) {
            res = node.val;
            return;
        }

        dfs(node.right, k );
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
