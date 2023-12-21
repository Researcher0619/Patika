import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number: ");
        int targetNumber = scanner.nextInt();

        int[] myArray = {15, 12, 788, 1, -1, -778, 2, 0};

        // Variables to store the closest smaller and larger numbers
        int closestSmaller = Integer.MIN_VALUE;
        int closestLarger = Integer.MAX_VALUE;

        // Iterate through the array to find the closest smaller and larger numbers
        for (int number : myArray) {
            // Check for the closest smaller number
            if (number < targetNumber && number > closestSmaller) {
                closestSmaller = number;
            }
            // Check for the closest larger number
            if (number > targetNumber && number < closestLarger) {
                closestLarger = number;
            }
        }

        // Display the results
        System.out.println("Closest number smaller than the entered number: " + closestSmaller);
        System.out.println("Closest number larger than the entered number: " + closestLarger);
    }
}
