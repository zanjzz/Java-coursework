package codes;
import java.util.Scanner;

public class NumberGuessingGame {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int randomNum = (int) (Math.random() * 100) + 1, userGuess, attempts = 1;
		boolean isGuessed = false;
		
		System.out.println("I've chosen a number between 1 and 100. You have 10 attempts.");
		// This loop runs 10 times maximum only
		for (int i = 10; i >= 1; --i) {
			System.out.print("Enter your guess: ");
			userGuess = s.nextInt();
			// Exit loop if guessed
			if (userGuess == randomNum) {
				isGuessed = true;
			 	break;
			}
			// Increment attempts and displaying feedback cleanly using ternary operator
			attempts++;
			if (i != 1) {
				System.out.println((userGuess > randomNum ? 
						"Too high!" : "Too low!") + " Remaining attempts: " + (i - 1));			 			
			} 
		}
		// Displaying correct output if  the user guessed it or not
		if (isGuessed) {
			System.out.println("Correct! you guessed the number in " + attempts +
					(attempts == 1 ? " attempt." : " attempts."));
		} else {
			System.out.println("No more attempts left, "
					+ "You failed to guess the random number: " + randomNum + ".");		
		}
		s.close();
	}
}
