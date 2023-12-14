// FINDING PRICE OF PLANE TICKET

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int kilometer, pricePerKilometer = 10, age;
        double total;
        boolean isReturnIncluded;

        // Prompt the user to enter the distance
        System.out.print("Enter the distance: ");
        kilometer = scanner.nextInt();

        // Prompt the user to enter whether return is included
        System.out.print("Is return included? (true/false): ");
        isReturnIncluded = scanner.nextBoolean();

        // Calculate the total based on the distance and return option
        total = kilometer * pricePerKilometer * (isReturnIncluded ? 2 : 1);

        // Prompt the user to enter their age
        System.out.print("Enter your age: ");
        age = scanner.nextInt();

        // Apply discount based on age
        if (age < 12) {
            total *= 0.5;
        } else if (age < 24) {
            total *= 0.9;
        } else if (age > 65) {
            total *= 0.7;
        }

        // Output the total price
        System.out.println("Total: " + total + " TL");
    }
}
