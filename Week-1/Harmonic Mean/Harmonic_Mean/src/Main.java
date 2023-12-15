import java.util.Scanner;

// HARMONIC MEAN
public class Main {
    public static void main(String[] args) {
        // Create a Scanner object to get user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a number
        System.out.println("Please enter the number to be harmonic averaged : ");
        int number = scanner.nextInt();

        double harmonicMean = 0;

        // Calculate the harmonic mean
        for (double i = 1; i <= number; i++) {
            harmonicMean += (1 / i);
        }

        // Display the harmonic mean of the given number
        System.out.print("Harmonic mean of the given number : " + harmonicMean);

        // Close the scanner
        scanner.close();
    }
}
