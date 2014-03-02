//Demonstrates a programmer-defined Exception class

public class SongException extends Exception
{
	public SongException()
	{
		super("Song Exception thrown!");
		System.out.println("Exception thrown.");
	}
	
	public SongException(String message)
	{
		super(message);
		System.out.println(
		    "SongException invoked with an argument.");
	}
}