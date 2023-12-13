import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Let's name our Scanner class in order to get the values from the users
        Scanner numbers = new Scanner(System.in);

        //Getting number a from the user
        System.out.print("Enter a number: ");
        int a = numbers.nextInt();

        //Getting number b from the user
        System.out.print("Enter another number: ");
        int b = numbers.nextInt();

        //Getting number c from the user
        System.out.print("Enter another number: ");
        int c = numbers.nextInt();

        // Let's print the result.
        int result =  a+b*c-b;
        System.out.println("Result: " + result);

    }
}