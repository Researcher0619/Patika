// NUMBERS DİVİDED BY BOTH 3 AND 4

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // First, let's import our Scanner Class and name it in order to get input from the user
        Scanner inp = new Scanner(System.in);

        // Getting a number from the user
        System.out.print("Please enter a number : ");
        int number = inp.nextInt();

        // Variables to calculate average
        int sum = 0;
        int count = 0;

        // To find the numbers which can be divided by both 3 and 4, we should write a for loop
        for (int i = 1; i <= number; i++) {
            if ((i % 3 == 0) && (i % 4 == 0)) {

                // Calculate sum for average
                sum += i;
                count++;

            }
        }
        // Calculate and display the average
        double average = ( sum / count );
        System.out.print("Result : " + average);
    }
}
