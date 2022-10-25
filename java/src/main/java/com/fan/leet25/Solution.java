package com.fan.leet25;

import com.fan.utils.ListNode;
import com.fan.utils.ListNodeUtils;

import java.util.Arrays;

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode p = dummyHead;
        int count = 0;
        ListNode curStart = head;
        ListNode lastEnd = dummyHead; // initial value is dummyHead, the it will be the tail of last k group
        while (p.next != null) {
            count += 1;
            if (count == k) {
                ListNode nextStart = p.next.next;
                p.next.next = null;
                lastEnd.next = reverse(curStart);
                lastEnd = curStart;
                lastEnd.next = nextStart;
                curStart = nextStart;
                p = lastEnd;
                count = 0;
                continue;
            }
            p = p.next;
        }

        return dummyHead.next;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode res = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return res;
    }

    public static void main(String[] args) {
        var solu = new Solution();
        var head = ListNodeUtils.generateFromList(Arrays.asList(1, 2, 3, 4, 5));
        int k = 2;
        head = ListNodeUtils.generateFromList(Arrays.asList(1, 2, 3, 4, 5));
        k = 3;
        var res = solu.reverseKGroup(head, k);
        ListNodeUtils.printList(res);
    }
}
