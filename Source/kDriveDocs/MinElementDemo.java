// This program uses recursion to find the smallest value in an 
// array. Reversing the test Question on Midterm. 
 
public class MinElementDemo
{
	public static void main(String[] args)
	{
		int[] numbers = { 2, 12, 1999, 99, 100, 4, 7, 300 };
		System.out.println("The smallest value in the array is " +
		                   minElement(numbers, 0)); 
	}

	/**
	 * minElement method
	 * This method accepts an array and a starting subscript
	 * as arguments. It returns the smallest value in the
	 * array, starting at the specified subscript.
	 */

	public static int minElement(int[] array, int start)
	{
		int minRemaining;
		
		if (start == (array.length - 1))
			return array[start];
		else
		{
			minRemaining = minElement(array, start + 1);
			if (array[start] < minRemaining)   // change to less than
			{
				return array[start];
			}
			else
			{							
				return minRemaining;
			}	
		}
	}
}