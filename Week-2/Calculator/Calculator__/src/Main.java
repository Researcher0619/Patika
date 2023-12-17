import java.util.Scanner;

public class Main {

    // Addition operation
    static int sum(int a, int b) {
        int result = a + b;
        System.out.println("Sum: " + result);
        return result;
    }

    // Subtraction operation
    static int minus(int a, int b) {
        int result = a - b;
        System.out.println("Subtraction: " + result);
        return result;
    }

    // Multiplication operation
    static int times(int a, int b) {
        int result = a * b;
        System.out.println("Multiplication: " + result);
        return result;
    }

    // Division operation
    static int divided(int a, int b) {
        if (b == 0) {
            System.out.println("The second number must be different from 0");
            return 0;
        }
        int result = a / b;
        System.out.println("Division: " + result);
        return result;
    }

    // Power operation
    static int power(int a, int b) {
        int result = 1;
        for (int i = 1; i <= b; i++) {
            result *= a;
        }
        return result;
    }

    // Modulus operation
    static int mod(int a, int b) {
        return a % b;
    }

    // Calculate the area and perimeter of a rectangle.
    static void calc(int a, int b) {
        System.out.println("Perimeter: " + (2 * (a + b)));
        System.out.println("Area: " + (a * b));
    }

    public static void main(String[] args) {

        Scanner inp = new Scanner(System.in);

        int select;

        String menu = "1- Addition\n"
                + "2- Subtraction\n"
                + "3- Multiplication\n"
                + "4- Division\n"
                + "5- Power\n"
                + "6- Modulus\n"
                + "7- Rectangle Area and Perimeter\n"
                + "0- Exit";

        System.out.println(menu);

        while (true) {
            System.out.print("Please choose an operation: ");
            select = inp.nextInt();

            if (select == 0)
                break;

            System.out.print("Enter the first number: ");
            int a = inp.nextInt();

            System.out.print("Enter the second number: ");
            int b = inp.nextInt();

            switch (select) {
                case 1:
                    sum(a, b);
                    break;
                case 2:
                    minus(a, b);
                    break;
                case 3:
                    times(a, b);
                    break;
                case 4:
                    divided(a, b);
                    break;
                case 5:
                    System.out.println("Power calculation: " + power(a, b));
                    break;
                case 6:
                    System.out.println("Modulus operation: " + mod(a, b));
                    break;
                case 7:
                    calc(a, b);
                    break;
                default:
                    System.out.println("You entered an invalid operation: ");
            }
        }
    }
}
