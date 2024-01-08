import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create an array with 10 elements
        int[] myArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // Get user input for the index
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter an index (0-9): ");
        int index = scanner.nextInt();

        // Call the method and print the result
        try {
            int result = getElementAtIndex(myArray, index);
            System.out.println("Element at the specified index: " + result);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Method to retrieve an element at a specific index
    public static int getElementAtIndex(int[] array, int index) throws ArrayIndexOutOfBoundsException {
        // Throw an exception if the specified index is out of bounds
        if (index < 0 || index >= array.length) {
            throw new ArrayIndexOutOfBoundsException("Invalid index: " + index);
        }
        // Return the element at the specified index
        return array[index];
    }
}
