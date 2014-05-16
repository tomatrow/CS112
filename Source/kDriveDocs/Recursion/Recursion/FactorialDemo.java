// This program demonstrates the recursive method, factorial, represented by
// the notation, n! or for computer code factorial(n).
// The factorial of a nonnegative number is defined as:
// If n = 0 then factorial(n) = 1.
// If n > 0 then factorial(n) = 1 * 2 * 3 *...* n or the product of all
//   positive integers from 1 up to n.
// If n > 0, we can represent the code as factorial(n) = n * factorial(n - 1)

import java.util.Scanner;

public class FactorialDemo
{
	public static void main(String[] args)
	{
		int number;
		String reply = "Y";
		String trash;
		
		Scanner keyboard = new Scanner(System.in);
		
		do
		{
		
		// Get number from user
		System.out.println("Enter a nonnegative integer: ");
		number = keyboard.nextInt();
		trash = keyboard.nextLine();          // flush the buffer
		
		// Display Factorial by recursively calling the factorial method
		System.out.println(number + "! is " + factorial(number));
		
		// Ask user if they want to input another number
		System.out.println("Enter Y or y to repeat with another number, " +
		                   "else enter N or n.");
		reply = keyboard.nextLine();
		
		}while (reply.equalsIgnoreCase("Y"));
	}
	
	// Recursive Factorial method - returns the factorial of its
	// argument, which is assumed to be a nonnegative number.
	private static int factorial(int n)
	{
		if (n == 0)
			return 1;            // Base case
		else
			return n * factorial(n - 1);
	}
}