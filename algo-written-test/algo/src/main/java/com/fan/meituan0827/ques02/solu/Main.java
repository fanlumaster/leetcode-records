package com.fan.meituan0827.ques02.solu;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] operations = new int[m];
            for (int i = 0; i < m; i++) {
                operations[i] = sc.nextInt();
            }
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
            System.out.println(sb);
        }
    }
}
