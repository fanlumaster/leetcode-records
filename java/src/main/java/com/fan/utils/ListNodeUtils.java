package com.fan.utils;

import java.util.List;

public class ListNodeUtils {
    public static ListNode generateFromList(List<Integer> data) {
        ListNode dummy = new ListNode();
        ListNode dummyP = dummy;
        for (int i = 0; i < data.size(); i++) {
            ListNode curNode = new ListNode(data.get(i));
            dummyP.next = curNode;
            dummyP = dummyP.next;
        }
        return dummy.next;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) {
                System.out.print(" -> ");
            }
            head = head.next;
        }
        System.out.println();
    }
}
