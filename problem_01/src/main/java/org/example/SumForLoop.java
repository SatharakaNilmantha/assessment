package org.example;

public class SumForLoop {

    public static int sumUsingForLoop(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum =sum + i;
        }
        return sum;
    }
}
