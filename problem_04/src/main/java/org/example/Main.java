package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static String formLargestNumber(List<Integer> nums) {

        List <String> strNums = new ArrayList<>();

        for (int i = 0; i < nums.size(); i++) {
            int num = nums.get(i);
            String str = String.valueOf(num);
            strNums.add(str);
        }

        System.out.println(strNums);


        strNums = strNums.stream()
                .sorted((a, b) -> (b + a).compareTo(a + b))
                .collect(Collectors.toList());


        System.out.println(strNums);


        String result = "";
        for (int i = 0; i < strNums.size(); i++) {
            String str = strNums.get(i);
            result = result + str;
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(50, 2, 1, 9);
        System.out.println("Largest formed number: " + formLargestNumber(input)); // Output: 95021
    }
}