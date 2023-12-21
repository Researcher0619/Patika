import java.util.Arrays;

public class FindDuplicatePairs {
    // Helper function to search for a value in the array
    static boolean isFind(int[] arr, int value) {
        for (int i : arr) {
            if (i == value)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        // The main array for processing
        int[] list = {3, 7, 3, 3, 2, 9, 10, 21, 1, 33, 9, 1, 10, 10, 2, 2};
        // Array to store duplicate elements
        int[] duplicate = new int[list.length];
        // Starting index value to iterate over the second array
        int startIndex = 0;

        // Two for loops to find duplicate elements
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list.length; j++) {
                // If elements at different indices are equal, and
                // this value has not been added to the duplicate array before, add it
                if ((i != j) && (list[i] == list[j])) {
                    if (!isFind(duplicate, list[i])) {
                        duplicate[startIndex++] = list[i];
                    }
                    break;
                }
            }
        }
        System.out.println("Array: " + Arrays.toString(list));
        System.out.println("-----------------------------------------------------------");

        // Print duplicate numbers
        System.out.println("Duplicate numbers");
        for (int value : duplicate) {
            if (value != 0) {
                System.out.print(value + " ");
            }
        }

        // Print duplicate even numbers
        System.out.println("\nDuplicate even numbers");
        for (int value : duplicate) {
            if (value != 0 && value % 2 == 0) {
                System.out.print(value + " ");
            }
        }
    }
}
