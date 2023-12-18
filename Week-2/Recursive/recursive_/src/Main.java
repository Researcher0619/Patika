import java.util.Scanner;

public class Main {

    // Recursive method to apply the specified rule
    static void applyRule(int n) {
        // Base case: If n is 0 or negative, return
        if (n <= 0) {
            System.out.print(n + " ");
            return;
        }

        // Print the current value
        System.out.print(n + " ");

        // Recursive call with n - 5
        applyRule(n - 5);

        // Print the current value again after the recursive call
        System.out.print(n + " ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input for N
        System.out.print("Enter a value for N: ");
        int n = scanner.nextInt();

        // Apply the rule using the recursive method
        applyRule(n);
    }
}
