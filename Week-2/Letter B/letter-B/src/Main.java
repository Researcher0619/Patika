public class Main {
    public static void main(String[] args) {

        // Creating a 2D array with 7 rows and 4 columns
        String[][] letter = new String[7][4];

        // Nested loops to populate the array and create a pattern resembling the letter 'B'
        for (int i = 0; i < letter.length; i++) {
            for (int j = 0; j < letter[i].length; j++) {
                // Conditions to create the 'B' pattern
                if ((i == 0 || i == 3 || i == 6)) {
                    letter[i][j] = " *"; // Asterisks (*) for the top, middle, and bottom parts of the pattern
                } else if ((j == 0 || j == 3)) {
                    letter[i][j] = " *"; // Asterisks (*) for the left and right edges of the pattern
                } else {
                    letter[i][j] = "  "; // Spaces represent the empty parts within the pattern
                }
                // Printing array elements to display the created pattern
                System.out.print(letter[i][j]);
            }
            // Moving to a new line at the end of each row
            System.out.println();
        }
    }
}
