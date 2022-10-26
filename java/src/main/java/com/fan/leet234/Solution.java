package com.fan.leet234;

import com.fan.utils.ListNode;
import com.fan.utils.ListNodeUtils;

import java.util.Arrays;

public class Solution {
    public boolean isPalindrome(ListNode head) {
        StringBuilder listSb = new StringBuilder();
        while (head != null) {
            listSb.append((char) (head.val + '0'));
            head = head.next;
        }
        String s1 = listSb.toString();
        String s2 = listSb.reverse().toString();
        return s1.equals(s2);
    }

    public static void main(String[] args) {
        var solu = new Solution();
        var head = ListNodeUtils.generateFromList(Arrays.asList(1, 2, 2, 1));
        head = ListNodeUtils.generateFromList(Arrays.asList(1, 2));
        var res = solu.isPalindrome(head);
        System.out.println(res);
    }
}
