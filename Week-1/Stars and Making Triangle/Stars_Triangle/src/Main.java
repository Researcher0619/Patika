import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner inp = new Scanner(System.in);
        System.out.println("How many stars do you want a diamond to be made of? ");
        int stars = inp.nextInt();

        // Upper half of the diamond
        for (int i = 0; i < stars; i++) {
            for (int k = 0; k < stars - i - 1; k++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // Lower half of the diamond
        for (int i = 0; i < stars - 1; i++) {
            for (int k = 0; k <= i; k++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * (stars - i - 1) - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
