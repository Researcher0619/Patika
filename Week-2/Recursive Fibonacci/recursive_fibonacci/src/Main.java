public class Main {
    static int fib(int number) {
        // Base case: if the input is 1 or 2, return 1
        if (number == 1 || number == 2)
            return 1;

        // Recursive case: Fibonacci formula
        return fib(number - 1) + fib(number - 2);
    }

    public static void main(String[] args) {
        // Example usage: calculating the 5th Fibonacci number
        System.out.println(fib(5));
    }
}
