package com.fan.meituan0827.ques05.solu;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int T = sc.nextInt();

            int[] t = new int[k];
            for (int i = 0; i < k; i++) {
                t[i] = sc.nextInt();
            }

            int[] e = new int[n];
            for (int i = 0; i < n; i++) {
                e[i] = sc.nextInt();
            }

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
            System.out.println(res);
        }
    }
}
