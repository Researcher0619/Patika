import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the distance (KM): ");
        int distance = input.nextInt();

        System.out.print("Enter age: ");
        int age = input.nextInt();

        System.out.print("Select the travel type (1: One Way, 2: Round Trip): ");
        int tripType = input.nextInt();

        double price = distance * 0.10; // Price per kilometer: 0.10 TL / km

        if (distance < 0 || age < 0 || (tripType != 1 && tripType != 2)) {
            System.out.println("Invalid Input!");
        } else {
            if (age < 12) {
                // 50% discount for age under 12
                price *= 0.5;
            } else if (age >= 12 && age <= 24) {
                // 10% discount for age between 12 and 24
                price *= 0.9;
            } else if (age >= 65) {
                // 30% discount for age 65 and over
                price *= 0.7;
            }

            if (tripType == 2) {
                // 20% discount for round trip
                price *= 0.8;
                price = price * 2;    // Double the price for round trip
            }
            System.out.println("Total ticket price: " + price + " TL");
        }
    }
}
