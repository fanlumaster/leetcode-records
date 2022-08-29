package com.fan.meituan0827.ques02.mytest;

import java.util.*;

/**
 * 重新分配权重，然后定义排序规则，然后排序。
 */
public class Solution {

    public String getRes(int n, int m, int[] operations) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i + 1, 0);
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            map.put(operations[i], -(++count));
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (o1, o2) -> o1.getValue() - o2.getValue());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(list.get(i).getKey().toString());
            if (i == n - 1) {
                break;
            }
            sb.append(" ");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        var solu = new Solution();
        int n = 5;
        int m = 3;
        int[] operations = new int[]{2, 3, 4};
        String res = solu.getRes(n, m, operations);
        System.out.println(res);
    }
}
