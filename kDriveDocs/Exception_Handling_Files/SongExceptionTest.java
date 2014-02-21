//This class demonstrates the SongException class

import java.util.*;

public class SongExceptionTest
{
	public static void main(String[] args)
	{
		try
		{
			String songWord;
			
			Scanner keyboard = new Scanner(System.in);
			
			System.out.println("Enter a song title:");
			songWord = keyboard.nextLine();
			
			if (songWord.equals("Magic Bus"))
			    throw new SongException("Song Exception Thrown!");
			System.out.println("Congratulations! You got it right!");
		}
		
		catch(SongException e)
		{
			System.out.println("Wrong Song. Sorry!");
			System.out.println(e.getMessage());
		}
	}
}