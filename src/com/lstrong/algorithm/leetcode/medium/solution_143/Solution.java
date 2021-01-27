package com.lstrong.algorithm.leetcode.medium.solution_143;

import java.util.ArrayList;
import java.util.List;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/1/26 18:28<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {

    //空间复杂度：O(N)
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        List<ListNode> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur);
            cur = cur.next;
        }

        int i = 0, j = list.size() - 1;
        while (i < j) {
            list.get(i).next = list.get(j);
            i++;
            if (i == j) {
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;
    }


    //空间复杂度O(1)
    public void reorderList1(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode newHead = slow.next;
        slow.next = null;

        ListNode reverseList = reverseList(newHead);
        mergeList(head, reverseList);
    }


    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur = head;
        ListNode pre = null;
        ListNode next;

        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    private void mergeList(ListNode list1, ListNode list2) {

        ListNode l1;
        ListNode l2;

        while (list1 != null && list2 != null) {
            l1 = list1.next;
            l2 = list2.next;

            list1.next = list2;
            list1 = l1;

            list2.next = list1;
            list2 = l2;

        }

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
