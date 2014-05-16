// This class has a recursive method, message, which displays a
// message n times.

public class SimpleRecursion
{
	public static void message(int n)
	{
		if (n > 0)
		{
			System.out.println("This is a recursive method, n = " + n);
			message(n - 1);
		}
	
	// This statement will be done starting with the lowest level
	// or base case of the recursive function call and work its
	// way up the most complicated or top level which in our case
	// is n = 5. Notice that the recursive calls interrupt this statement
	// until the process is complete.
	
	System.out.println("I have gone through the method " + n 
		                   + " times.");
		                   
	// Each time a recursive call is made the value of n is stored on the
	// stack along with the routine. When the println method is called it
	// removes the values on the stack (pops) using the LIFO (Last in First
	// out method, hence, 0 is the first value we see.
	}
}