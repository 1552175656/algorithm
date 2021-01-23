package com.lstrong.algorithm.leetcode.medium.solution_92;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/1/23 18:02<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {

    //迭代
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }

        ListNode cur = head, pre = null;
        while (m > 1) {
            pre = cur;
            cur = cur.next;
            m--;
            n--;
        }

        ListNode nodeM = pre, tail = cur;
        ListNode next;
        while (n > 0) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            n--;
        }

        if(nodeM != null){
            nodeM.next = pre;
        }else {
            head = pre;
        }

        tail.next = cur;
        return head;
    }


    //递归
    public ListNode reverseBetweenR(ListNode head, int m, int n) {
        // base case
        if (m == 1) {
            return reverseN(head, n);
        }
        // 前进到反转的起点触发 base case
        head.next = reverseBetweenR(head.next, m - 1, n - 1);
        return head;

    }

    ListNode successor = null; // 后驱节点

    // 反转以 head 为起点的 n 个节点，返回新的头结点
    ListNode reverseN(ListNode head, int n) {

        if (head == null || head.next == null) {
            return head;
        }

        if (n == 1) {
            // 记录第 n + 1 个节点
            successor = head.next;
            return head;
        }
        // 以 head.next 为起点，需要反转前 n - 1 个节点
        ListNode last = reverseN(head.next, n - 1);

        head.next.next = head;
        // 让反转之后的 head 节点和后面的节点连起来
        head.next = successor;
        return last;
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
