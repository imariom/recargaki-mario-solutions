package com.mario;

import java.util.Scanner;

public class Test1 {
     public static void main(String[] args) {
        // Scanner to read input from the command line
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt(); // read the input from the input stream

        // Checks the value read from input stream
        if (number < 0) {
            System.out.println("Number is negative"); 
        } else if (number == 0) {
            System.out.println("Number is zero");
        } else {
            System.out.println("Number is positive");
        }

        // Generate and prints numbers from 1 to 6
        System.err.println("\nGenerate numbers from 1 to 5:");
        for (int i = 1; i != 6; ++i) {
            System.out.println(i);
        }
     }
}
