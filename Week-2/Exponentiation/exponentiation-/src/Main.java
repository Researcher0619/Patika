import java.util.Scanner;

public class Main {
    static int Recursive(int base, int exponent) {
        Scanner inp = new Scanner(System.in);
        System.out.println("Enter the number to be exponentiated : ");
        base = inp.nextInt();

        System.out.println("Enter the exponent value :");
        exponent = inp.nextInt();

        int result = 1;
        for (int i = 1; i <= exponent; i++) {
            result *= base;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Result :\n" + Recursive(2, 3));
    }
}