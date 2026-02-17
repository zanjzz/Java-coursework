package codes;
import java.util.Scanner;

public class GradeCalculator {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		char grade;

		System.out.print("Enter a numerical score (0-100): ");

		// String input validation
		if (!scanner.hasNextInt()) {
			System.out.println("Invalid input! Please enter a number.");
			scanner.close();
			return;
		}

		int score = scanner.nextInt();

		// Range input validation
		if (score < 0 || score > 100) {
			System.out.println("Invalid input! Score must be between 0 and 100.");
		} else {
			if (score >= 90) grade = 'A';
			else if (score >= 80) grade = 'B';
			else if (score >= 70) grade = 'C';
			else if (score >= 60) grade = 'D';
			else grade = 'F';

			System.out.println("Letter Grade: " + grade);
		}
		scanner.close();
	}
}
