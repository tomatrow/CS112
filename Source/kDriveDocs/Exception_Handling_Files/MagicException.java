//Demonstrates a programmer-defined Exception class

public class MagicException extends Exception
{
	public MagicException()
	{
		super("Magic Exception thrown!");
		System.out.println("Wow, it's a Magic Exception thrown!");
	}
	
	public MagicException(String message)
	{
		super(message);
		System.out.println(
		    "Wow! Magic Exception thrown with an argument.");
	}
	public void magicMethod()
	{
		System.out.println(
		    "The magic message is: " + getMessage());
	}
}