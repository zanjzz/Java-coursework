package test;
import java.util.Scanner;
public class TemperatureConverter {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		//Getting the input from user
		System.out.print("Enter temperature in Fahrenheit: ");
		double fahrenheit = s.nextDouble();
		
		//Formula for conversion
		double celsius = (fahrenheit - 32) * 5.0 / 9.0;
		
		//Displaying formatted output
		System.out.printf("Fahrenheit: %.2f%nCelsius: %.2f%n", fahrenheit, celsius);

		s.close();

	}

}
