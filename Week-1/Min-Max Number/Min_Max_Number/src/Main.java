import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        System.out.print("How many numbers will you enter? ");
        int choice = inp.nextInt();

        // Create an array to store entered numbers
        int[] numbers = new int[choice];

        // Initialize variables for the greatest and minimum numbers
        int greatestNum = Integer.MIN_VALUE; // Initialize with the smallest possible integer
        int minNum = Integer.MAX_VALUE; // Initialize with the largest possible integer

        // Loop to get user input and find greatest and minimum numbers
        for (int i = 0; i < choice; i++) {
            System.out.print("Please enter " + (i + 1) + ". number: ");
            numbers[i] = inp.nextInt();

            // Update greatestNum if the current number is greater
            if (numbers[i] > greatestNum) {
                greatestNum = numbers[i];
            }

            // Update minNum if the current number is smaller
            if (numbers[i] < minNum) {
                minNum = numbers[i];
            }
        }

        // Printing all entered numbers
        System.out.print("Entered numbers: ");
        for (int i = 0; i < choice; i++) {
            System.out.print(numbers[i] + ", ");
        }

        // Print the greatest and min numbers
        System.out.println("\nThe greatest number out of given numbers: " + greatestNum);
        System.out.println("The minimum number out of given numbers: " + minNum);
    }
}
