package org.example;

public class SumWhileLoop {
    public static int sumUsingWhileLoop(int n) {
        int sum = 0;
        int i = 1;
        while (i <= n) {
            sum = sum + i ;
            i++;
        }
        return sum;
    }
}
