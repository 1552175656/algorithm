package com.lstrong.algorithm.leetcode.easy.solution_203;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/1/24 12:15<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode cur = dummyHead;
        while (cur.next != null){
            if(cur.next.val == val){
                ListNode delNode = cur.next;
                cur.next = delNode.next;
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
