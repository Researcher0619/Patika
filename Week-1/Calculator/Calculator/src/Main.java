import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // First, let's import and name our Scanner class
        Scanner numbers = new Scanner(System.in);

        // Let's get the first number from the user
        System.out.print("Enter the first number: ");
        int n1 = numbers.nextInt();

        // Let's get the second number from the user
        System.out.print("Enter the second number: ");
        int n2 = numbers.nextInt();

        // Let's ask the user which function he/she wants to use
        System.out.print("Select operation:\n1- Addition\n2- Subtraction:\n3- Multiplication\n4- Division\n");

        int choice = numbers.nextInt();

        // Use a switch statement to perform the selected operation
        switch (choice) {
            // If the user chooses 1
            case 1:
                System.out.println("Addition: " + (n1 + n2));
                break;

            // If the user chooses 2
            case 2:
                System.out.println("Subtraction: " + (n1 - n2));
                break;

            // If the user chooses 3
            case 3:
                System.out.println("Multiplication: " + (n1 * n2));
                break;

            // If the user chooses 4
            case 4:
                // Convert the boolean condition to an integer (0 or 1)
                int divisionChoice = n2 != 0 ? 1 : 0;

                // Use a switch statement for the division choice
                switch (divisionChoice) {
                    // If n2 is not zero
                    case 1:
                        System.out.println("Division: " + ((double) n1 / n2));
                        break;

                    // If n2 is zero
                    case 0:
                        System.out.println("A number cannot be diivided by 0 !!!!.");
                        break;

                    // You can add more cases if needed
                    default:
                        System.out.println("Invalid division choice.");
                }
                break;

            // If the user enters an invalid choice
            default:
                System.out.println("Invalid choice. Please enter a number between 1 and 4.");
        }
    }
}
