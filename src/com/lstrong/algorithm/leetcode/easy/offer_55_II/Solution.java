package com.lstrong.algorithm.leetcode.easy.offer_55_II;

import javax.swing.tree.TreeNode;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/1/10 17:55<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {

    public boolean isBalanced(TreeNode root) {

        if(root == null){
            return true;
        }

        if(Math.abs(getHeight(root.left) - getHeight(root.right)) > 1){
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int getHeight(TreeNode node) {

        if (node == null) {
            return -1;
        }

        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }


    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
