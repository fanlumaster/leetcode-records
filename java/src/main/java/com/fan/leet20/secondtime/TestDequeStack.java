package com.fan.leet20.secondtime;

import java.util.Deque;
import java.util.LinkedList;

public class TestDequeStack {
    public static void main(String[] args) {
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        System.out.println(stack);
        System.out.println(stack.peek());
        while (stack.size() != 0) {
            System.out.print(stack.pop());
            System.out.print(", ");
        }
        System.out.println();
    }
}
