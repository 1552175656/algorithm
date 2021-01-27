package com.lstrong.algorithm.leetcode.medium.solution_234;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/1/26 18:30<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {

    public boolean isPalindrome(ListNode head) {

        if (head == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode l1 = head;
        ListNode halfList = slow.next;
        slow.next = null;
        ListNode l2 = reverseList(halfList);
        while (l1 != null && l2 != null){
            if(l2.val != l1.val){
                return false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }


        return true;
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
