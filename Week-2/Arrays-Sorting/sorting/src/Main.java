import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner inp = new Scanner(System.in);
        System.out.println("How many elements should the array consist of? :");
        int n = inp.nextInt();

        int[] myArray = new int[n];

        // Get array elements from the user
        for (int i = 0; i < n; i++) {
            System.out.println("Please enter the " + (i + 1) + ". number of the array");
            myArray[i] = inp.nextInt();
        }

        // Sort the array in ascending order
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (myArray[j] > myArray[j + 1]) {
                    // Swap elements if they are in the wrong order
                    int temp = myArray[j];
                    myArray[j] = myArray[j + 1];
                    myArray[j + 1] = temp;
                }
            }
        }

        // Display the sorted array
        System.out.println("Sorted Array in Ascending Order: " + Arrays.toString(myArray));
    }
}
