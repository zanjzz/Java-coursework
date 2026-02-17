package codes;
import java.util.Scanner;

public class PatternPrinting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int rows = 6, cols = 6;
        
        // Get user choice
        System.out.print("Enter pattern type (triangle, pyramid, diamond): ");
        String pattern = scanner.nextLine().toLowerCase();
        
        // Using switch for concise execution
        switch (pattern) {
            case "triangle":
               	for (int i = 0; i < rows; ++i) {
        		   	for (int j = 0; j < rows; ++j) {
        		        System.out.print("*");
                        if (j >= i) break; 
                        /* This will stop loop depending on "i" to print the star count properly */		  
        		    }
        		    System.out.println();
        		} break;
                
            case "pyramid":
                // Create a descending amount of spaces using cols - i
            	for (int i = 1; i <= rows; i++) {
                    for (int j = 1; j <= cols + rows; j++) {
                        // Skip until spacing is done
                        if (j <= cols - i) {
                            System.out.print(" ");
                            continue;
                        }
                        // Stop after enough stars are printed
                        if (j > cols - i + (i * 2 - 1)) {
                            break;
                        }
                        System.out.print("*");
                    }
                    System.out.println();
                } break;

            case "diamond":
                // First we copy the pyramid pattern
            	for (int i = 1; i <= rows; i++) {
            	    for (int j = 1; j <= cols + rows; j++) {
            	        if (j <= cols - i) {
            	            System.out.print(" ");
            	            continue;
            	        }
            	        if (j > cols - i + (i * 2 - 1)) {
            	            break;
            	        }
            	        System.out.print("*");
            	    }
            	    System.out.println();
            	}

               // Adding another one but reversing it to create a diamond shape
            	for (int i = rows - 1; i >= 1; i--) {
            	    for (int j = 1; j <= cols + rows; j++) {
            	        if (j <= cols - i) {
            	            System.out.print(" ");
            	            continue;
            	        }
            	        if (j > cols - i + (i * 2 - 1)) {
            	            break;
            	        }
            	        System.out.print("*");
            	    }
            	    System.out.println();
            	} break;
                
                default:
                    System.out.println("Invalid input!");
        }
        scanner.close();
    }
}