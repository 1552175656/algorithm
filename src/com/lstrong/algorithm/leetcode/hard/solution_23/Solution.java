package com.lstrong.algorithm.leetcode.hard.solution_23;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/1/29 15:01<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        ListNode pre = null;
        for (int i = 0; i < lists.length; i++) {
            pre = mergeList(pre, lists[i]);
        }

        return pre;
    }

    private ListNode mergeList(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }

        if (list2 == null) {
            return list1;
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }

        cur.next = list1 == null ? list2 : list1;
        return dummy.next;
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
