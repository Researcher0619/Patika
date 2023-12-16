// Prime Numbers Between 1 and 100

public class Main {
    public static void main(String[] args) {
        System.out.println("Prime numbers between 1 and 100: ");

        // Loop through numbers from 2 to 100
        for (int number = 2; number <= 100; number++) {
            boolean isPrime = true;

            // Check for factors other than 1 and the number itself
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    // If a factor is found, set isPrime to false and break the loop
                    isPrime = false;
                    break;
                }
            }

            // If isPrime is true, the number is prime, so print it
            if (isPrime) {
                System.out.print(number + " ");
            }
        }
    }
}
