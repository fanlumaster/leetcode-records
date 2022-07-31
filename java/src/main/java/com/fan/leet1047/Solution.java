package com.fan.leet1047;

import java.util.Stack;
import java.util.stream.Collectors;

public class Solution {
    public String removeDumplicates(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(chars[i]);
            } else if (stack.peek() == chars[i]) {
                stack.pop();
            } else {
                stack.push(chars[i]);
            }
        }

        return stack.stream().map(e -> e.toString()).collect(Collectors.joining());
    }

    public static void main(String[] args) {
        var solu = new Solution();
        String s = "abbaca";
        var res = solu.removeDumplicates(s);
        System.out.println(res);
    }
}
