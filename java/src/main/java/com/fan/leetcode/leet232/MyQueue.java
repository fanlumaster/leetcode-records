package com.fan.leetcode.leet232;

import java.util.Stack;

public class MyQueue {
    private Stack<Integer> stackIn;
    private Stack<Integer> stackOut;

    public MyQueue() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    public void push(int x) {
        stackIn.push(x);
    }

    public int pop() {
        if (stackOut.empty()) {
            dumpStackInToOut();
        }

        return stackOut.pop();
    }

    public int peek() {
        if (stackOut.empty()) {
            dumpStackInToOut();
        }

        return stackOut.peek();
    }

    public boolean empty() {
        return stackIn.empty() && stackOut.empty();
    }

    public void dumpStackInToOut() {
        while (!stackIn.isEmpty()) {
            stackOut.push(stackIn.pop());
        }
    }

    public static void main(String[] args) {
        var queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.pop());
        queue.push(3);
        queue.push(4);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.empty());
    }
}
