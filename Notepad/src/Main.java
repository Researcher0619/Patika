import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Enter Text");
            System.out.println("2. Read Saved Text");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear the newline character left behind by nextInt

            switch (choice) {
                case 1:
                    enterTextAndSave(scanner);
                    break;
                case 2:
                    readSavedText();
                    break;
                case 3:
                    System.out.println("Exiting the program...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void enterTextAndSave(Scanner scanner) {
        System.out.print("Enter a text: ");
        String text = scanner.nextLine();

        try (FileWriter fileWriter = new FileWriter("notes.txt");
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            printWriter.print(text);
            System.out.println("Text successfully saved.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public static void readSavedText() {
        try (FileReader fileReader = new FileReader("notes.txt");
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String readText = bufferedReader.readLine();
            if (readText != null) {
                System.out.println("Saved text: " + readText);
            } else {
                System.out.println("No text has been saved yet.");
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }
}
