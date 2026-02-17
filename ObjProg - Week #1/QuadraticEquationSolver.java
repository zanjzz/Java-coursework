package test;
import java.util.Scanner;
public class QuadraticEquationSolver {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		
		//Getting all the coefficients from the user needed for the equation
		System.out.print("Enter coefficient a: ");
		double a = s.nextDouble();	
		
		System.out.print("Enter coefficient b: ");
		double b = s.nextDouble();	
		
		System.out.print("Enter coefficient c: ");
		double c = s.nextDouble();
		
		if (a == 0) {
			//If a is zero, terminate immediately, it's not quadratic anymore
			System.out.print("a = 0! Not a quadratic equation."); 
			s.close();
			return;
		}
		
		//Declaration for checking the discriminant
		double discriminant = Math.pow(b, 2) - 4 * a * c;

		/* Here we check if the discriminant < 0, and solve for the real and imaginary numbers
		because we cannot proceed to the original formula if the number inside the square root is negative */
		if (discriminant < 0) {
		    double real = -b / (2 * a);
		    double imag = Math.sqrt(-discriminant) / (2 * a);
		    //Two outputs each for positive and negative results
		    System.out.printf("Roots: %.2f + %.2fi and %.2f - %.2fi%n", real, imag, real, imag);
		    
		} else if (discriminant == 0) {
			System.out.printf("Root: %.2f", -b / (2 * a)); //single root case
				
		} else {
			//Normal quadratic solution, same equation for positive and negative just different signs
			double root1 = (-(b) + Math.sqrt(discriminant)) / (2 * a);
			double root2 = (-(b) - Math.sqrt(discriminant)) / (2 * a);
			System.out.printf("Roots: %.2f and %.2f", root1, root2);
		}
		s.close();
	}
}
