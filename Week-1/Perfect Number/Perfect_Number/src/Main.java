import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("Please enter a number! ");
        int number = inp.nextInt();

        int counter = 0;
        int[] values = new int[number];  // Assuming the maximum number of divisors is the entered number

        // Find divisors and store them in the 'values' array
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                values[counter] = i;
                counter++;
            }
        }

        System.out.print("Divisors: ");
        for (int i = 0; i < counter; i++) {
            System.out.print(values[i] + " ");
        }

        // Check if it is a perfect number
        int sum = 0;
        for (int i = 0; i < counter; i++) {
            sum += values[i];
        }

        // Display whether it's a perfect number or not
        if (sum == number) {
            System.out.println("\n " + number + " is a perfect number");
        } else {
            System.out.println("\n " + number + " is not a perfect number");
        }
    }
}
