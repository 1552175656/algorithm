package com.lstrong.algorithm.leetcode.medium.solution_19;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/1/26 18:18<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode first = dummyHead;
        ListNode second = dummyHead;

        for (int i = 0; i < n + 1; i++) {
            second = second.next;
        }

        while (second != null) {
            first = first.next;
            second = second.next;
        }

        ListNode delNode = first.next;
        first.next = delNode.next;

        return dummyHead.next;
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
