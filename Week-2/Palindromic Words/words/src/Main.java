import java.util.Scanner;

public class Main {
    // Function to check if a string is a palindrome
    static boolean isPalindrome(String str) {
        String reverse = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reverse += str.charAt(i);
        }
        return (str.equals(reverse));
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // User input
        System.out.print("Enter a word: ");
        String word = input.nextLine().toUpperCase();

        // Check if the entered word is a palindrome
        if (isPalindrome(word)) {
            System.out.println("It is a palindromic word.");
        } else {
            System.out.println("It is not a palindromic word.");
        }
    }
}
