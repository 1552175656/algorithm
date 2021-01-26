package com.lstrong.algorithm.leetcode.easy.solution_21;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/1/24 13:07<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {
    //递归
    public ListNode mergeTwoListsR(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        if (l1.val < l2.val) {
            l1.next = mergeTwoListsR(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoListsR(l1, l2.next);
            return l2;
        }

    }

    //迭代
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        cur.next = l1 == null ? l2 : l1;
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
