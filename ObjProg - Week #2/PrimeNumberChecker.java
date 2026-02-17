package codes;
import java.util.Scanner;

public class PrimeNumberChecker {
	public static void main(String[] args) {
	    Scanner s = new Scanner(System.in);
		
	    boolean isPrime = true;
	    
	    // User Input
	    System.out.print("Enter a number greater than 1: ");
	    int num = s.nextInt();
	    
	    // Input validation, end program quickly
		if (num <= 1) {
			System.out.println("Invalid Input!");
			s.close();
			return;
		}

		// Optimized loop with i * i instead of Math.sqrt(), same outcome
	    for (int i = 2; i * i <= num; i++) {
	    	//If num has a divisor, means its not a prime anymore
	        if (num % i == 0) {
	        	isPrime = false;
	        	break;
	        }
	    }
	    // Using ternary for cleanly displaying the output
	    System.out.println(num + " is " + (isPrime ? "a" : "not a") + " prime number.");

	    s.close();
	}
}
