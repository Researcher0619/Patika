import java.util.Scanner;

// ARMSTRONG NUMBERS
public class Main {
    public static void main(String[] args) {

        // Create a Scanner object to get user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a number
        System.out.println("Please enter a number : ");
        int number = scanner.nextInt();
        int digit;
        int sumOfDigits = 0;

        // Extract each digit and calculate the sum
        while (number != 0) {
            digit = number % 10;
            number /= 10;

            // Print each extracted digit
            System.out.println("Each digit of the number : " + digit);

            // Add the digit to the sum
            sumOfDigits += digit;
        }

        // Display the sum of the digits
        System.out.println("Sum of the each digit of the given number by user : " + sumOfDigits);

        // Close the scanner
        scanner.close();
    }
}
