// Exponentiation Operations

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Exponential Calculation");

        // Taking base and exponent values from the user
        System.out.print("Enter the base value: ");
        int base = input.nextInt();

        System.out.print("Enter the exponent value: ");
        int power = input.nextInt();

        // Calculating the result
        int result = 1;
        for (int i = 1; i <= power; i++) {
            result *= base; // Multiplying the base by itself power times
        }

        // Displaying the result
        System.out.println("Result: " + result);

        input.close();
    }
}
