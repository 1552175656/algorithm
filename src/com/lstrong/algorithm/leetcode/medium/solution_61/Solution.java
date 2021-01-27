package com.lstrong.algorithm.leetcode.medium.solution_61;

import java.util.List;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/1/26 18:25<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        ListNode oldTail = head;
        int length = 0;
        while (oldTail.next != null) {
            length++;
            oldTail = oldTail.next;
        }


        oldTail.next = head;
        
        ListNode newTail = head;
        for (int i = 1; i <= length - (k % length) - 1; i++) {
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
