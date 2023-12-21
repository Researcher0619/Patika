import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int row;
        int col;

        // Asking for the number of rows and columns from the user
        System.out.print("Enter the number of rows: ");
        row = input.nextInt();
        System.out.print("Enter the number of columns: ");
        col = input.nextInt();

        // Creating a matrix based on the user-input rows and columns
        int[][] matrix = new int[row][col];
        System.out.println("Matrix ");

        int value = 1;
        // Assigning values to the original matrix and printing it to the screen
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                matrix[r][c] = value;
                value++;
                System.out.print(matrix[r][c] + "  ");
            }
            System.out.println();
        }

        // Next, creating the transpose matrix
        int[][] transposeMatrix = new int[col][row];
        System.out.println("---------");
        System.out.println("Transpose ");
        // Printing the transpose matrix to the screen
        for (int r = 0; r < transposeMatrix.length; r++) {
            for (int c = 0; c < transposeMatrix[r].length; c++) {
                // Copying values to obtain the transpose of the original matrix
                transposeMatrix[r][c] = matrix[c][r];
                System.out.print(transposeMatrix[r][c] + "  ");
            }
            System.out.println();
        }
    }
}
