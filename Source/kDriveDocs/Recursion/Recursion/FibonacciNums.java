// This program demonstrates the recursive method, fibNums. This math 
// problem was designed to be solved recursively.
// The Fibonacci numbers are represented by the following sequence;
// 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233,...etc.
// Notice that after the second number, each number in the series is the
// sum of the two previous numbers.
// The Fibonacci series can be defined using subscripts as;
//   1. F(0) = 0 and F(1) = 1
//   2. F(n) = F(n-1) + F(n-2) for N>= 2


import java.util.Scanner;

public class FibonacciNums
{
	public static void main(String[] args)
	{
		int number = 0;
		String reply = "Y";
		String trash;
		boolean flag = true;
		
		Scanner keyboard = new Scanner(System.in);
		
		do
		{
			// Get number from user
			while (flag)
			{
				System.out.println("Enter how many numbers in the Fibonacci series "
				                   + "you would like to see: ");
				number = keyboard.nextInt();
				trash = keyboard.nextLine();          // flush the buffer
		
				// Check to see if user entered a invalid number. If not, break out of loop.
				if (number > 0)
				{
					break; 
				}
		
				System.out.println("Your number must be greater than 0.");
			} //end while loop
			
		// Display the Fibonacci series up to the ith user number entered
		// by recursively calling the fibNums method. The numbers in the series
		// are zero-based, therefore, if the user asks for the 10th number, the
		// number at index number 9 will be displayed.
		System.out.println();
		System.out.println("The first " + number + " numbers in the series are: ");

		// Call the recursive fibNums method
		for (int i = 0; i < number; i++)
		{
			System.out.print(fibNums(i) + " ");
		}

		// Ask user if they want to input another number
		System.out.println();                 // flush the print buffer
		System.out.println();
		System.out.println("Enter Y or y to repeat with another number, " +
		                   "else enter N or n.");
		reply = keyboard.nextLine();
		System.out.println();

		}while (reply.equalsIgnoreCase("Y"));
	}
	
	// Recursive fibNums method - returns the nth number in the Fibonacci series.
	private static int fibNums(int n)
	{
		if (n == 0)
			return 0;            // Base case
		else if (n == 1)
			return 1; 
		else
			return (fibNums(n - 1) + fibNums(n - 2));
	}
}
