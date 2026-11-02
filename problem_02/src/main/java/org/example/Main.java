package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static List<String> mergList(List<String> list1 , List<String> list2) {

        List<String> result = new ArrayList<>();

        int a = list1.size();
        int b = list2.size() ;

        int maxSize = a+b;

        for (int i = 0; i < maxSize; i++) {
            if (i < list1.size()) {
                result.add(list1.get(i));
            }
            if (i < list2.size()) {
                result.add(list2.get(i));
            }
        }

        return result;
    }

    public static void main(String[] args) {

        List<String> list1 = new ArrayList<>();
        list1.add("a");
        list1.add("b");
        list1.add("c");

        List<String> list2 = new ArrayList<>();
        list2.add("1");
        list2.add("2");
        list2.add("3");

        List <String> merged = mergList(list1, list2);
        System.out.println(merged);
    }
}