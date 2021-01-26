package com.lstrong.algorithm.leetcode.medium.solution_148;

import java.util.List;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/1/24 19:50<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {

    //递归
    public ListNode sortListR(ListNode head) {

        return sort(head);
    }


    private ListNode sort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }


        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow.next;
        slow.next = null;
        ListNode list1 = sortList(head);
        ListNode list2 = sortList(mid);

        return merge(list1, list2);
    }

    private ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;

        while (list1 != null && list2 != null) {

            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }

        cur.next = list1 == null ? list2 : list1;

        return dummyHead.next;
    }


    //迭代
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode node = head;
        int length = 0;
        while (node != null){
            length++;
            node = node.next;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        for (int subLength = 1; subLength < length; subLength <<= 1) {
            ListNode prev = dummyHead, cur = dummyHead.next;
            while (cur != null){
                ListNode head1 = cur;
                for (int i = 1; i < subLength && cur.next != null; i++) {
                    cur = cur.next;
                }
                ListNode head2 = cur.next;
                cur.next = null;
                cur = head2;
                for (int i = 1; i < subLength && cur != null && cur.next != null; i++) {
                    cur = cur.next;
                }
                ListNode next = null;
                if(cur != null){
                    next = cur.next;
                    cur.next = null;
                }

                ListNode merged = merge(head1, head2);
                prev.next = merged;
                while (prev.next != null){
                    prev = prev.next;
                }
                cur = next;
            }
        }


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
