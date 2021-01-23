package com.lstrong.algorithm.leetcode.easy.solution_206;

import java.util.List;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/1/23 16:48<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {


    //迭代
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        ListNode next;

        while (cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    //递归
    public ListNode reverseListR(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode rev = reverseListR(head.next);
        head.next.next = head;
        head.next = null;

        return rev;
    }

    public class ListNode {
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
