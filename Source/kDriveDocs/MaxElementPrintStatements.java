// This program uses recursion to find the largest value in an 
// array. Test Question on Midterm. 
 
public class MaxElementPrintStatements
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
		int maxRemaining = 0;   // compiler required initialization
		
		if (start == (array.length - 1))
		{
		    System.out.println("I just entered MaxElement with start at: "
		    	               + start + " and maxRemaining at: " + maxRemaining);
			return array[start];
		}
		else
		{
			maxRemaining = maxElement(array, start + 1);
			if (array[start] > maxRemaining)
			{
                System.out.println("I am in Array with start at: " + start +
		    	               " maxRemaining at: " + maxRemaining + " array[start] at: "
		    	               + array[start]);				
				return array[start];
			}
			else
			{							
				System.out.println("I am in Array with start at: " + start +
		    	               " maxRemaining at: " + maxRemaining + " array[start] at: "
		    	               + array[start]);	
				return maxRemaining;
			}	
		}
	}
}