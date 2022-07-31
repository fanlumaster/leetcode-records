package com.fan.leet225;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        queue1.offer(x);
    }

    public int pop() {
        while (queue1.size() != 1) {
            queue2.offer(queue1.poll());
        }
        int res = queue1.poll();
        while (queue2.size() != 0) {
            queue1.offer(queue2.poll());
        }

        return res;
    }

    public int top() {
        while (queue1.size() != 1) {
            queue2.offer(queue1.poll());
        }
        int res = queue1.peek();
        while (queue2.size() != 0) {
            queue1.offer(queue2.poll());
        }

        return res;
    }

    public boolean empty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) {
        var mystack = new MyStack();
        mystack.push(1);
        mystack.push(2);
        System.out.println(mystack.pop());
        mystack.push(3);
        mystack.push(4);
        System.out.println(mystack.pop());
        System.out.println(mystack.pop());
        System.out.println(mystack.pop());
        System.out.println(mystack.empty());
    }
}
