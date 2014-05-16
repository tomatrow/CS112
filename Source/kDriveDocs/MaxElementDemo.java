// This program uses recursion to find the largest value in an 
// array. Test Question on Midterm. 
 
public class MaxElementDemo
{
	public static void main(String[] args)
	{
		int[] numbers = { 2, 12, 1999, 99, 100, 4, 7, 300 };
		System.out.println("The largest value in the array is " +
		                   maxElement(numbers, 0)); 
	}

	/**
	 * maxElement method
	 * This method accepts an array and a starting subscript
	 * as arguments. It returns the largest value in the
	 * array, starting at the specified subscript.
	 */

	public static int maxElement(int[] array, int start)
	{
		int maxRemaining;
		
		if (start == (array.length - 1))
			return array[start];
		else
		{
			maxRemaining = maxElement(array, start + 1);
			if (array[start] > maxRemaining)
			{
				return array[start];
			}
			else
			{							
				return maxRemaining;
			}	
		}
	}
}
