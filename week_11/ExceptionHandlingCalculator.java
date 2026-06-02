package week_11;
import java.util.Scanner;
public class ExceptionHandlingCalculator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char operator;
		Double num1, num2;
		
		try {
			System.out.print("Enter first number: ");
			num1 = Double.parseDouble(scanner.nextLine());
			
			System.out.print("Enter second number: ");
			num2 = Double.parseDouble(scanner.nextLine());
			
			System.out.print("Enter an operator(+, - , *, /): ");
			operator = scanner.nextLine().charAt(0);
			
			checkOp(operator);
			
			double result = compute(num1, num2, operator);
			
			// Formatting the display for decimals and integers
			if (result == (int) result) {
				System.out.print("Result: " + (int) result);
			} else {
				System.out.print("Result: " + result);
			}
			
		// These catch blocks will handle different kinds of exception
		} catch (ArithmeticException ae) {
			System.out.println("Error: Division by zero is not allowed.");
		} catch (InvalidOperatorException ioe) {
			System.out.println(ioe.getMessage());
		} catch (NumberFormatException nfe) {
			System.out.println("Error: Invalid input. Please enter valid numbers");
		}
		
		scanner.close();
	}
	// Function that throws an exception and validate the operator input
	static void checkOp(char op) throws InvalidOperatorException {
		if (op == '+' || op == '-' || op == '*' || op == '/') {
			return;
		} else {
			throw new InvalidOperatorException("Caught custom exception: Invalid operator. Valid operators are +, -, *, /.");
		}
	}
	// Function for operator computations
	static double compute(double num1, double num2, char operator) {
		switch (operator) {
			case '+': return num1 + num2;
			case '-': return num1 - num2;
			case '*': return num1 * num2;
			case '/': 
				if (num2 == 0) {
					// This will throw the exception if the num was divided by zero
					throw new ArithmeticException();
				}
				return num1 / num2;
		}
		return -1;
	}
}
// Custom exception for invalid operator
class InvalidOperatorException extends Exception {
	private static final long serialVersionUID = 1L;

	InvalidOperatorException(String message) {
		super(message);
	}
}

