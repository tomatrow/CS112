//This class demonstrates how the Finally block works in conjunction with
//Exception Handling

public class FinallyDemo
{
	public static void main(String[] args)
	{
		try
		{
			myMethod(-10);
		}
		
		catch(Exception e)
		{
		System.out.println("Catch in main.");
		System.out.println(e.getMessage());
		}
	}
	
	public static void myMethod(int n) throws Exception
	{
		try
		{
			if (n > 0)
				throw new Exception();
			else if (n < 0)
				throw new NegativeNumberException();
			else
				System.out.println("No Exception.");
			System.out.println("Still in myMethod.");
		}
		catch(NegativeNumberException e)
		{
		System.out.println("Caught in myMethod.");
		}
		finally
		{
			System.out.println("In finally block.");
		}
		System.out.println("After finally block.");
	}
}