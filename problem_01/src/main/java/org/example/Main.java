package org.example;


public class Main {

    public static void main(String[] args) {
        int n = 10;

        System.out.println("Sum of 1 to " + n + ":");

        SumForLoop sumForLoop = new SumForLoop();
        System.out.println("Using for loop:    " + sumForLoop.sumUsingForLoop(n));

        SumWhileLoop sumWhileLoop = new SumWhileLoop();
        System.out.println("Using while loop:  " + sumWhileLoop.sumUsingWhileLoop(n));

        SumRecursion sumRecursion = new SumRecursion();
        System.out.println("Using recursion:   " + sumRecursion.sumUsingRecursion(n));
    }
}