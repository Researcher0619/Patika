// Exponent Number


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        System.out.println("Enter the number to be exponentiated : ");
        int a = inp.nextInt();

        System.out.println("Enter the exponent value : ");
        int b = inp.nextInt();

        double total = 1;

        // Press Ctrl+R or click the green arrow button in the gutter to run the code.
        for (int i = 1; i <= b; i++) {

            total *= a;
        }
        System.out.println("Result : " + total);
    }
}