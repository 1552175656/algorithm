package com.lstrong.algorithm.leetcode.easy.solution_237;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/1/26 17:31<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {

    public void deleteNode(ListNode node) {
        if(node == null) {
            return;
        }

        if(node.next == null){
            node = null;
            return;
        }

        node.val = node.next.val;
        ListNode delNode = node.next;
        node.next = delNode.next;

    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
