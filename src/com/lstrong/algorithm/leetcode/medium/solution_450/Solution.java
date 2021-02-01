package com.lstrong.algorithm.leetcode.medium.solution_450;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/1/30 22:22<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {

        if (root == null) {
            return null;
        }

        if (root.val < key) {
            root.right =  deleteNode(root.right, key);
        } else if (root.val > key) {
            root.left =  deleteNode(root.left, key);
        } else {
            if (root.left == null && root.right == null) {
                root =  null;
            } else if (root.left != null) {
                root.val = predecessor(root);
                root.left = deleteNode(root.left, root.val);
            } else {
                root.val = successor(root);
                root.right = deleteNode(root.right, root.val);
            }
        }

        return root;
    }

    private int successor(TreeNode node) {
        node = node.right;
        while (node.left != null) {
            node = node.left;
        }

        return node.val;
    }

    private int predecessor(TreeNode node) {
        node = node.left;
        while (node.right != null) {
            node = node.right;
        }
        return node.val;
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
