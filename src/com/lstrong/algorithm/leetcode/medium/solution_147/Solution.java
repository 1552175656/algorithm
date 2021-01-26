package com.lstrong.algorithm.leetcode.medium.solution_147;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/1/24 19:49<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode lastSorted = head, cur = head.next;
        while (cur != null) {
            if (lastSorted.val <= cur.val) {
                lastSorted = lastSorted.next;
            } else {
                ListNode lessThanCur = dummyHead;
                while (lessThanCur.next != null && lessThanCur.next.val <= cur.val) {
                    lessThanCur = lessThanCur.next;
                }
                lastSorted.next = cur.next;
                cur.next = lessThanCur.next;
                lessThanCur.next = cur;
            }
            cur = lastSorted.next;
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
