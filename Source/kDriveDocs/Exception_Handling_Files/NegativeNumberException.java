//Demonstrates a programmer-defined Exception class

public class NegativeNumberException extends Exception
{
	public NegativeNumberException()
	{
		super("Negative Number Exception!");
	}
	
	public NegativeNumberException(String message)
	{
		super(message);
	}
}