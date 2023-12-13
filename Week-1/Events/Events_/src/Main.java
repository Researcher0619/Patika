// EVENTS

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        // Create a Scanner object for user input
        Scanner input = new Scanner(System.in);
        int temperature;

        // Get the temperature from the user
        System.out.print("Enter the temperature: ");
        temperature = input.nextInt();

        // Suggest activity based on the temperature
        String activity = (temperature < 5 ?  "You can go skiing." : "") ;

        if (temperature >= 5 && temperature <= 25) {
            // If temperature is between 5 and 25, enter this block
            if (temperature <= 15) {
                System.out.println("You can go to the cinema.");
            }
            if (temperature >= 10) {
                System.out.println("You can go for a picnic.");
            }
        } else {
            System.out.println("You can go swimming.");
        }
    }
}
