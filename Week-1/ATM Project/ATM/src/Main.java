import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Initialize variables
        String username, password;
        Scanner inp = new Scanner(System.in);
        int balance = 1500, attempts = 3, option;

        // User authentication loop
        while (attempts > 0) {
            System.out.println("Please enter your username:");
            username = inp.nextLine();

            System.out.println("Please enter your password:");
            password = inp.nextLine();

            // Check username and password
            int authenticationResult = (username.equals("patika") && password.equals("dev123")) ? 1 : 2;

            System.out.println();

            switch (authenticationResult) {
                case 1:
                    System.out.println("Welcome to Kodluyoruz Bank!");
                    System.out.println();

                    // Transaction loop
                    do {
                        System.out.println("1. Deposit Money");
                        System.out.println("2. Withdraw Money");
                        System.out.println("3. Check Balance");
                        System.out.println("4. Exit");
                        System.out.print("Please choose the transaction you want to perform: ");
                        option = inp.nextInt();

                        // Execute selected transaction
                        switch (option) {
                            case 1:
                                System.out.print("Enter the amount you want to deposit: ");
                                int depositAmount = inp.nextInt();
                                balance += depositAmount;
                                System.out.println("Your balance now: " + balance);
                                break;
                            case 2:
                                System.out.print("Enter the amount you want to withdraw: ");
                                int withdrawAmount = inp.nextInt();

                                // Check if sufficient funds are available
                                if (withdrawAmount > balance) {
                                    System.out.println("Insufficient funds.");
                                } else {
                                    balance -= withdrawAmount;
                                    System.out.println("Your balance now: " + balance);
                                }
                                break;
                            case 3:
                                System.out.println("Your Balance: " + balance);
                                break;
                        }
                    } while (option != 4);

                    System.out.println("Thank you for using Kodluyoruz Bank!");
                    break;

                case 2:
                    System.out.println("Incorrect username or password. Please try again.");
                    attempts--;

                    // Handle remaining attempts and account blocking
                    if (attempts > 0) {
                        System.out.println("Attempts remaining: " + attempts);
                    } else {
                        System.out.println("Your account has been blocked.");
                        System.out.println("Please contact the bank.");
                    }
                    break;
            }
        }
    }
}
