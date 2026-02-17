package test;
import java.util.Scanner;
public class SimpleInterestCalculator {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		//Getting inputs from user
		System.out.print("Enter principal amount: ");
		double principal = s.nextDouble();
		
		System.out.print("Enter interest rate: ");
		double rate = s.nextDouble();
		
		System.out.print("Enter time period (years): ");
		double time = s.nextDouble();
		
		//Formula for the simple interest
		double interest = (principal * rate * time) / 100;
		
		//Displaying formatted output
		System.out.printf("Simple Interest: %.2f%n", interest);
		
		s.close();
	}
}
