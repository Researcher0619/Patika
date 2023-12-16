// Inverted Triangle Generator

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        // Get the number of rows for the inverted triangle
        System.out.print("Please enter the number of rows to form an inverted triangle: ");
        int numRows = inp.nextInt();

        // Generate the inverted triangle pattern
        for (int i = 0; i < numRows; i++) {
            // Print leading spaces
            for (int k = 0; k <= i; k++) {
                System.out.print(" ");
            }

            // Print asterisks
            for (int j = 0; j < 2 * (numRows - i) - 1; j++) {
                System.out.print("*");
            }

            // Move to the next line
            System.out.println();
        }
    }
}
