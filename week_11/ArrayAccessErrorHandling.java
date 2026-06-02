package week_11;
import java.util.Scanner;

public class ArrayAccessErrorHandling {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int[] arr = {67, 69, 30, 143};
		String input;
		
		try {
			System.out.print("Enter an index: ");
			input = scanner.nextLine();
			
			int index = Integer.parseInt(input);
			System.out.println("Element at index " + index + " is: " + arr[index]);
			// The catch block will handle it if the index is invalid
			
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Error: Array index out of bounds.");
		} catch (NumberFormatException e) {
			System.out.println("Error: Please enter an integer.");
		}
		
		scanner.close();
	}

}


