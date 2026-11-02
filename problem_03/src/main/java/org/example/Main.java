package org.example;


public class Main {
    public static void main(String[] args) {


        long a = 0; // First number = 0
        long b = 1; // Second number = 1

        System.out.println("Fibonacci 1: " + a);
        System.out.println("Fibonacci 2: " + b);

        for (int i = 3; i <= 100; i++) {

            long c = a + b;

            System.out.println("Fibonacci " + i + ": " + c);


            a = b;
            b = c;
        }
    }
}