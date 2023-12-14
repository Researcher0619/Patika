// FINDING ZODIAC SIGN

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int day, month;

        // Get day and month information from the user
        System.out.print("Enter your birth day: ");
        day = input.nextInt();

        System.out.print("Enter your birth month: ");
        month = input.nextInt();

        // Check for valid day and month input
        if ((day > 0 && day <= 31) && (month > 0 && month <= 12)) {
            String zodiacSign = "";

            // Calculate the zodiac sign based on the given day and month
            if ((month == 3 && day >= 21) || (month == 4 && day <= 20)) {
                zodiacSign = "Aries";
            } else if ((month == 4 && day >= 21 && day <= 30) || (month == 5 && day <= 21)) {
                zodiacSign = "Taurus";
            } else if ((month == 5 && day >= 22) || (month == 6 && day <= 22)) {
                zodiacSign = "Gemini";
            } else if ((month == 6 && day >= 23 && day <= 30) || (month == 7 && day <= 22)) {
                zodiacSign = "Cancer";
            } else if ((month == 7 && day >= 23) || (month == 8 && day <= 22)) {
                zodiacSign = "Leo";
            } else if ((month == 8 && day >= 23) || (month == 9 && day <= 22)) {
                zodiacSign = "Virgo";
            } else if ((month == 9 && day >= 23 && day <= 30) || (month == 10 && day <= 22)) {
                zodiacSign = "Libra";
            } else if ((month == 10 && day >= 23) || (month == 11 && day <= 21)) {
                zodiacSign = "Scorpio";
            } else if ((month == 11 && day >= 22 && day <= 30) || (month == 12 && day <= 21)) {
                zodiacSign = "Sagittarius";
            } else if ((month == 12 && day >= 22) || (month == 1 && day <= 21)) {
                zodiacSign = "Capricorn";
            } else if ((month == 1 && day >= 22) || (month == 2 && day <= 19)) {
                zodiacSign = "Aquarius";
            } else if ((month == 2 && day >= 20 && day <= 29) || (month == 3 && day <= 20)) {
                zodiacSign = "Pisces";
            }

            // Print the calculated zodiac sign
            System.out.println("Your zodiac sign is: " + zodiacSign);
        } else {
            // Display a warning for invalid date input
            System.out.println("Invalid date input.");
        }
    }
}
