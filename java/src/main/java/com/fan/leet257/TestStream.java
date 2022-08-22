package com.fan.leet257;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestStream {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "test", "what");
        System.out.println(list);
        String[] strings = list.toArray(String[]::new);
        System.out.println(Arrays.toString(strings));

        List<Integer> integerList = Arrays.asList(1, 2, 3, 4);
        System.out.println(integerList);
        List<String> testString = integerList.stream().map(a -> a.toString()).collect(Collectors.toList());
        System.out.println(testString);
        String[] intStrings = integerList.stream().map(a -> a.toString()).toArray(String[]::new);
        System.out.println(Arrays.toString(intStrings));
    }
}
