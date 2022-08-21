package com.fan.leet102;

import java.util.LinkedList;
import java.util.Queue;

public class TestQueue {
    public static void main(String[] args) {
        Queue<Integer> myQueue = new LinkedList<>();
        myQueue.offer(1); // 入队函数
        myQueue.offer(2);
        myQueue.offer(3);
        myQueue.offer(4);
        myQueue.offer(5);
        System.out.println(myQueue);
        Integer header = myQueue.poll();// 出队函数
        System.out.println("********");
        System.out.println(header);
        System.out.println("********");
        System.out.println(myQueue);
    }
}
