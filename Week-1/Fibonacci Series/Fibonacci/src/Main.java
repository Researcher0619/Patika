import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the number of elements for the Fibonacci series from the user
        System.out.print("Enter the number of elements for the Fibonacci series: ");
        int number = scanner.nextInt();

        int firstNumber = 0, secondNumber = 1, nextNumber;

        System.out.println("Fibonacci Series");


        // Generate and print the Fibonacci series
        for (int i = 1; i <= number; i++) {
            System.out.print(firstNumber + " "); // Print the previous number at each step

            nextNumber = firstNumber + secondNumber; // The sum of two consecutive numbers creates the new number
            firstNumber = secondNumber; // Update the previous numbers to calculate the new number
            secondNumber = nextNumber;
        }
    }
}
