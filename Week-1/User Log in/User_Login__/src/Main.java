import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Declare variables for username, password, answer, new password, and wrong password
        String userName, password, answer, newPassword, wrongPassword = "";

        // Import Scanner class for user input
        Scanner inp = new Scanner(System.in);

        // Get the username from the user
        System.out.print("Please enter your username: ");
        userName = inp.nextLine();

        // Get the password from the user
        System.out.print("Please enter your password: ");
        password = inp.nextLine();

        // Check username and password
        if (userName.equals("patika") && password.equals("java123")) {
            System.out.println("You have logged in successfully!");
        } else {
            // If the password is incorrect, assign it to the wrongPassword variable
            if (!password.equals("java123")) {
                wrongPassword = password;
            }
            System.out.println("Your password is incorrect!");

            // Ask if the user forgot the password and wants to reset it
            System.out.print("Did you forget your password? Do you want to reset your password? (Yes/No): ");
            answer = inp.nextLine();

            // Process based on Yes/No answer
            int yesNo = answer.equalsIgnoreCase("Yes") ? 1 : 2;

            switch (yesNo) {
                case 1:
                    boolean validPassword = false;

                    // Continue to prompt for a new password until a valid one is entered
                    while (!validPassword) {
                        System.out.print("Please enter your new password: ");
                        newPassword = inp.nextLine();

                        // Check if the newPassword is not "java123" or equal to the wrongPassword
                        if (!(newPassword.equals("java123") || newPassword.equals(wrongPassword))) {
                            System.out.println("New password has been arranged.");
                            validPassword = true; // Exit the loop
                        } else {
                            System.out.println("New password has not been created. Please enter a new password.");
                        }
                    }
                    break;

                default:
                    System.out.println("Invalid choice. Please enter 'Yes' or 'No'.");
            }
        }
    }
}
