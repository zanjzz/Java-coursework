package codes;
import java.util.Scanner;

public class FactorialCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input
        System.out.print("Enter a non-negative integer: ");

        // Input validation
        if (!scanner.hasNextLong()) {
            System.out.println("Invalid input! Please enter an integer.");
        } else {
            long num = scanner.nextLong();

            if (num < 0) {
                System.out.println("Invalid input! Number must be non-negative.");
            } else if (num > 20) {
                System.out.println("Number too large for factorial!");
            } else {
                long factorialResult = 1;

                for (long i = 1; i <= num; i++) {
                    factorialResult *= i;
                }

                System.out.println("Factorial of " + num + ": " + factorialResult);
            }
        }

        scanner.close();
    }
}
