package com.lstrong.algorithm.leetcode.medium.solution_437;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/1/30 21:16<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        int result = findPathSum(root, sum);
        result += pathSum(root.left, sum);
        result += pathSum(root.right, sum);

        return result;
    }

    private int findPathSum(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }

        int res = 0;
        if (node.val == sum) {
            res += 1;
        }

        res += findPathSum(node.left, sum - node.val);
        res += findPathSum(node.right, sum - node.val);

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
