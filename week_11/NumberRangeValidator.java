package week_11;
import java.util.Scanner;

public class NumberRangeValidator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num;
		
		try {	
				System.out.print("Enter a number between 1-100: ");
				num = Integer.parseInt(scanner.nextLine());
				
				checkRange(num);	
				
		} catch (OutOfRangeException ofre) {
			System.out.println(ofre.getMessage());
		} catch (NumberFormatException nfe) {
			System.out.println("Error: Invalid input. Please enter a valid number.");
		} finally {
			System.out.println("Thank you for your input!");
		}
		
		scanner.close();
	}

	static void checkRange(int num) throws OutOfRangeException{
		// Validate input to ensure it falls within the allowed range (1–100)
		if (num > 100 || num < 1) {
			throw new OutOfRangeException("Caught custom exception: Input out of range. "
										 + "Please enter a number between 1 and 100.");
		} else {
			System.out.println("You entered: " + num);
		}
	}	
}
// Custom exception for out of range
class OutOfRangeException extends Exception {
	private static final long serialVersionUID = 1L;
	 
	public OutOfRangeException(String message) {
		super(message);
	}
}