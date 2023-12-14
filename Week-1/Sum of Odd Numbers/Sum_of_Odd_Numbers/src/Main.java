// SUM OF ODD NUMBERS

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Let's import our Scanner Class and name it
        Scanner inp = new Scanner(System.in);
        int n;
        int total = 0;

        do {
            // Let's get the numbers from the user
            System.out.print("Please enter a number : ");
            n = inp.nextInt();

            if ((n % 2 == 0) && (n % 4 == 0)) {

                // FORMULA :
                // Sum of numbers which can be divided by 4 and are even given by the user
                total += n;
            }

        } while ((n > 0) && (n % 2 == 0));

        // Let's print out the solution
        System.out.print("Total : " + total);

    }

}
