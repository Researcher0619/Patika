import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int birthYear; // User's birth year

        System.out.print("Enter your birth year: ");
        birthYear = input.nextInt();
        System.out.println("---------------------");

        /* Calculate the Chinese Zodiac sign. Assign a specific Chinese Zodiac sign based on the remainder 
            when the birth year is divided by 12. */
        switch (birthYear % 12) {
            case 0:
                System.out.println("Your Chinese Zodiac Sign: Monkey");
                break;
            case 1:
                System.out.println("Your Chinese Zodiac Sign: Rooster");
                break;
            case 2:
                System.out.println("Your Chinese Zodiac Sign: Dog");
                break;
            case 3:
                System.out.println("Your Chinese Zodiac Sign: Pig");
                break;
            case 4:
                System.out.println("Your Chinese Zodiac Sign: Rat");
                break;
            case 5:
                System.out.println("Your Chinese Zodiac Sign: Ox");
                break;
            case 6:
                System.out.println("Your Chinese Zodiac Sign: Tiger");
                break;
            case 7:
                System.out.println("Your Chinese Zodiac Sign: Rabbit");
                break;
            case 8:
                System.out.println("Your Chinese Zodiac Sign: Dragon");
                break;
            case 9:
                System.out.println("Your Chinese Zodiac Sign: Snake");
                break;
            case 10:
                System.out.println("Your Chinese Zodiac Sign: Horse");
                break;
            case 11:
                System.out.println("Your Chinese Zodiac Sign: Sheep");
                break;
            default:
                System.out.println("Invalid input.");
        }
    }
}
