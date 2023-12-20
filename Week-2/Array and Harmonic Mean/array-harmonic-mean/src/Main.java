import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();

        // Define the array
        double[] numbers = new double[n];

        // Get numbers from the user
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            numbers[i] = scanner.nextDouble();
        }

        // Calculate harmonic average
        double harmonicAverage = calculateHarmonicAverage(numbers);

        System.out.println("Harmonic Average: " + harmonicAverage);

        scanner.close();
    }

    // Method to calculate harmonic average
    public static double calculateHarmonicAverage(double[] array) {
        double sum = 0;

        // Calculate harmonic series
        for (double num : array) {
            sum += 1 / num;
        }

        return array.length / sum;
    }
}
