package com.fan.leet23;

import java.util.*;

public class TestProirityQ {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1 - o2);
        pq.offer(5);
        pq.offer(2);
        pq.offer(1);
        pq.offer(3);
        pq.offer(4);
        pq.offer(6);
        while (pq.size() != 0) {
            System.out.println(pq.poll());
        }
    }
}
