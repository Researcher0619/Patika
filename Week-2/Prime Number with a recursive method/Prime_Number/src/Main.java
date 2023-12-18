import java.util.Scanner;

public class Main {

    // Recursive method to check if a number is prime
    static boolean isPrime(int number, int divisor) {
        // If the number is less than 2, it is not prime
        if (number < 1) {
            return false;
        }

        // If the divisor exceeds the square root of the number, it is prime
        // Eğer bölen, sayının karekökünden büyükse, asal sayıdır
        //Bu satır, asal sayı kontrolü sırasında bir optimizasyon sağlar.
        // Asal sayı kontrolünde, bir sayının bölenlerini bulmaya çalışırız.
        // Ancak şu gerçekleşir: Bir sayının karekökü, sayıdan büyükse,
        // o zaman geriye kalan bölenler zaten sayının küçük olan yarısını aşamaz.
        if (divisor * divisor > number) {
            return true;
        }

        // If the number is divisible by the current divisor, it is not prime
        if (number % divisor == 0) {
            return false;
        }

        // Recursive call to check the next divisor
        return isPrime(number, divisor + 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Check if the entered number is prime
        if (isPrime(number, 2)) {
            System.out.println(number + " is a prime number.");
        } else {
            System.out.println(number + " is not a prime number.");
        }
    }
}
