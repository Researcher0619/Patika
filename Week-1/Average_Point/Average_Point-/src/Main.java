// PASSING CLASS OR NOT

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Create a Scanner object for user input
        Scanner lessons = new Scanner(System.in);

        // Declare variables for lesson scores
        int Math, Physics, Turkish, Chemistry, Music;

        // Prompt the user to enter Math score and read the input
        System.out.print("Please enter your Math score: ");
        Math = lessons.nextInt();

        // Repeat the process for other subjects
        System.out.print("Please enter your Physics score: ");
        Physics = lessons.nextInt();

        System.out.print("Please enter your Turkish score: ");
        Turkish = lessons.nextInt();

        System.out.print("Please enter your Chemistry score: ");
        Chemistry = lessons.nextInt();

        System.out.print("Please enter your Music score: ");
        Music = lessons.nextInt();

        // Create an array to store lesson scores
        int[] Final_Average = {Math, Physics, Turkish, Chemistry, Music};

        // Initialize variables for sum, total lessons, and average
        double sum = 0;
        double totalLessons = 0;
        double average;

        // Iterate through the array to calculate sum and count valid lessons
        for (int i = 0; i < Final_Average.length; i++) {
            // Check if the score is within the valid range
            if (Final_Average[i] >= 0 && Final_Average[i] <= 100) {
                sum += Final_Average[i];
                totalLessons++;
            } else {
                // Handle scores outside the valid range (if needed)
            }
        }

        // Check if at least one valid lesson score is entered
        if (totalLessons > 0) {
            // Calculate the average
            average = sum / totalLessons;

            // Print the calculated average
            System.out.println("Average: " + average);

            // Check if the average is greater than or equal to 55 and provide feedback
            if (average >= 55) {
                System.out.println("Congratulations! You passed the class.");
            } else {
                System.out.println("Sorry, see you next year.");
            }
        } else {
            // Print a message if no valid scores are entered
            System.out.println("No valid scores entered.");
        }
    }
}
