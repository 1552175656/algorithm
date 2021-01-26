package com.lstrong.algorithm.leetcode.medium.solution_82;

import java.util.List;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/1/24 12:35<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {

    //递归
    public ListNode deleteDuplicatesR(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        if (head.val == head.next.val) {
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            return deleteDuplicatesR(head.next);
        } else {
            head.next = deleteDuplicatesR(head.next);
            return head;
        }
    }

    //迭代
    public ListNode deleteDuplicates(ListNode head){
        if(head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode cur = dummyHead;

        while (cur.next != null && cur.next.next != null){
            if(cur.next.val == cur.next.next.val){
                ListNode temp = cur.next;
                while (temp.next != null && temp.val == temp.next.val){
                    temp = temp.next;
                }
                cur.next = temp.next;
            }else {
                cur = cur.next;
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
