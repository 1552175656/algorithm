package com.lstrong.algorithm.leetcode.medium.solution_113;

import java.util.ArrayList;
import java.util.List;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/1/30 14:57<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        helper(root, targetSum, path, res);
        return res;
    }

    private void helper(TreeNode node, int targetSum, List<Integer> path, List<List<Integer>> res) {
        if (node == null) {
            return;
        }

        path.add(node.val);
        targetSum -= node.val;
        if (node.left == null && node.right == null && targetSum == 0) {
            res.add(new ArrayList<>(path));
        }

        helper(node.left, targetSum, path, res);
        helper(node.right, targetSum, path, res);

        path.remove(path.size() - 1);

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
