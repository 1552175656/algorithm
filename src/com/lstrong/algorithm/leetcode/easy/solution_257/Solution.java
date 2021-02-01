package com.lstrong.algorithm.leetcode.easy.solution_257;

import java.util.ArrayList;
import java.util.List;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/1/30 11:26<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        if (root.left == null && root.right == null) {
            res.add(root.val + "");
            return res;
        }

        List<String> leftS = binaryTreePaths(root.left);
        for (String s : leftS) {
            res.add(root.val + "" + "->" + s);
        }

        List<String> rightS = binaryTreePaths(root.right);
        for (String s : rightS) {
            res.add(root.val + "" + "->" + s);
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
