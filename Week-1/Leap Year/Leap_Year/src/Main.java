// LEAP YEAR
import java.util.Scanner;

/**
 * A simple program to determine whether a given year is a leap year.
 * A leap year is divisible by 4 but not divisible by 100, or it is divisible by 400.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for the input year
        System.out.print("Enter a year: ");
        int year = scanner.nextInt();

        // Check if the year is a leap year
        boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);

        // Display the result
        System.out.println(year + " is a leap year? " + isLeapYear);


    }
}
