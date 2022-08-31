package com.fan.meituan0827.ques03.mytest;

import java.util.ArrayList;
import java.util.List;

public class TestList {
    public static void main(String[] args) {
        List<String> sList = new ArrayList<>();
        sList.add("hell");
        sList.add("paradise");
        sList.add("tell");
        sList.add("bold");
        sList.add("poll");
        System.out.println(sList);
        sList.remove(2);
        System.out.println(sList);
        sList.add(2, "tell");
        System.out.println(sList);
    }
}
