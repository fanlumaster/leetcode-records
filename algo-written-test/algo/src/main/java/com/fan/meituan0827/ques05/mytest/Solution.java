package com.fan.meituan0827.ques05.mytest;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 直接优先队列一把梭
 */
public class Solution {
    public int getRes(int n, int k, int T, int[] t, int[] e) {
        Queue<Integer> queue = new PriorityQueue<>();
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (e[i] == 0) {
                if (queue.size() == 0) {
                    res += T;
                } else {
                    if (queue.peek() < T) {
                        res += queue.poll();
                    } else {
                        res += T;
                    }
                }
            } else {
                queue.offer(t[e[i] - 1]);
            }
        }

        return res;
    }

    public static void main(String[] args) {

    }
}
