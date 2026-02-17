package codes;
import java.util.Scanner;

public class LeapYearChecker {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		// Get user input
		System.out.print("Enter a year: ");
		
		// String input validation
				if (!scanner.hasNextInt()) {
					System.out.println("Invalid input! Please enter a number.");
					scanner.close();
					return;
				}

		int year= scanner.nextInt();
		
		/* I used "OR" and "AND" for the leap year condition, 
		 where it must be divisible by 4, except century years or divisible by 400 */
		if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
			System.out.println(year + " is a leap year."); 
		}
		else {
			System.out.println(year + " is not a leap year.");
		}
		scanner.close();
	}

}
