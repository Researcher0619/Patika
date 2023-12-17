import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Using the Scanner class to get input from the user
        Scanner scanner = new Scanner(System.in);

        // Asking the user to enter an integer
        System.out.print("Enter an integer: ");
        int integerNumber = scanner.nextInt();

        // Asking the user to enter a decimal number
        System.out.print("Enter a decimal number: ");
        double decimalNumber = scanner.nextDouble();

        // Converting integer to a decimal number
        double integerToDecimal = (double) integerNumber;

        // Converting decimal number to an integer
        int decimalToInteger = (int) decimalNumber;

        // Printing the results to the console
        System.out.println("Entered Integer: " + integerNumber);
        System.out.println("Entered Decimal Number: " + decimalNumber);
        System.out.println("Convert Integer to Decimal: " + integerToDecimal);
        System.out.println("Convert Decimal to Integer: " + decimalToInteger);

        // Closing the Scanner
        scanner.close();
    }
}
