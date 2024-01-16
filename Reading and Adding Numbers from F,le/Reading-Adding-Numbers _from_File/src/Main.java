import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class ReadFileAndSumNumbers {

    public static void main(String[] args) {
        // File path and name
        String filePath = "file.txt";

        try {
            // Read the file using FileReader and BufferedReader
            BufferedReader br = new BufferedReader(new FileReader(filePath));

            // Variable to store the sum
            int totalSum = 0;

            // File reading process
            String line;
            while ((line = br.readLine()) != null) {
                // Parse the string to an integer and add to the sum
                int number = Integer.parseInt(line);
                totalSum += number;
            }

            // Print the sum of the numbers read from the file
            System.out.println("Total sum of numbers read from the file: " + totalSum);

            // Close the BufferedReader
            br.close();
        } catch (IOException e) {
            // Handle IOException that may occur during file reading
            System.err.println("File reading error: " + e.getMessage());
        }
    }
}
