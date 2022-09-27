package com.fan.algointerview.huawei.first;

// huawei first interview algo problem
// 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
//
// 示例:
//
// 给定 1->2->3->4, 你应该返回 2->1->4->3.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode pointer = head;
        ListNode res = null;
        if (pointer != null && pointer.next != null) {
            res = pointer.next;
            ListNode tmp = pointer.next.next;
            pointer.next.next = pointer;
            pointer.next = swapPairs(tmp);
        } else {
            return pointer;
        }

        return res;
    }

    public static void main(String[] args) {
        var solu = new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ListNode pointer = head;
        while (pointer != null) {
            // System.out.println(pointer.val);
            pointer = pointer.next;
        }
        System.out.println("-----------");
        var res = solu.swapPairs(head);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
