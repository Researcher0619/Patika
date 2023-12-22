import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        int number = rand.nextInt(100);

        Scanner input = new Scanner(System.in);
        int right = 0;
        int selected;
        int[] wrong = new int[5];
        boolean isWin = false;
        boolean isWrong = false;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("You have 5 attempts to guess the hidden number between 0 and 100.");

        while (right < 5) {
            System.out.println("--------------------------");
            System.out.print("Please enter your guess: ");
            selected = input.nextInt();

            if (selected < 0 || selected > 99) {
                System.out.println("Please enter a value between 0 and 100.");
                if (isWrong) {
                    right++;
                    System.out.println("You made too many wrong entries. Remaining attempts: " + (5 - right));
                } else {
                    isWrong = true;
                    System.out.println("If you make one more wrong entry, it will be deducted from your attempts.");
                }
                continue;
            }

            if (selected == number) {
                System.out.println("Congratulations, correct guess! The hidden number was: " + number);
                isWin = true;
                break;
            } else {
                System.out.println("You entered an incorrect number!");
                if (selected > number) {
                    System.out.println(selected + " is greater than the hidden number.");
                } else {
                    System.out.println(selected + " is less than the hidden number.");
                }

                wrong[right++] = selected;
                System.out.println("Remaining attempts: " + (5 - right));
            }
        }

        if (!isWin) {
            System.out.println("You lost! The hidden number was: " + number);
            if (!isWrong) {
                System.out.println("Your guesses: " + Arrays.toString(wrong));
            }
        }

    }
}
