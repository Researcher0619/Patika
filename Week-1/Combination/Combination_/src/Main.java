import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Combination Calculation");
        System.out.println("-----------------------");

        // Get values of n and r from the user
        System.out.print("Enter the value of n: ");
        int n = input.nextInt();

        System.out.print("Enter the value of r: ");
        int r = input.nextInt();

        // FORMULA C(n,r) = n! / (r! * (n-r)!)

        // Check for invalid input
        if (r > n || r < 0) {
            System.out.println("Invalid input. r cannot be greater than n or negative.");
        } else {
            // Calculate and display the combination
            int c = calculateCombination(n, r);
            System.out.println("Combination: " + c);
        }

        input.close();
    }

    // Function to calculate combination
    public static int calculateCombination(int n, int r) {
        return factorial(n) / (factorial(r) * factorial(n - r));
    }

    // Helper function to calculate factorial
    public static int factorial(int num) {
        int result = 1;
        for (int i = 1; i <= num; i++) {
            result *= i;
        }
        return result;
    }
}


