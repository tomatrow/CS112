//This program opens a binary file, reads and displays
//the contents which are in an int array.

import java.io.*;

public class ReadBinaryFile
{
	public static void main(String[] args) throws IOException
	{
		int number;
		boolean endOfFile = false;         //flag for EOF
		
		//Open a binary file, numbers.dat, for input
		
		//FileInputStream fstream =  new FileInputStream("numbers.dat");
		//DataInputStream inFile = new DataInputStream(fstream);
		//or
		DataInputStream inFile = new DataInputStream(
			                     new FileInputStream("numbers.dat"));
		
		System.out.println("Reading numbers from the file.");
		
		//Read data from the file
		while (!endOfFile)
		{
			try
			{
				number = inFile.readInt();
				System.out.println(number  + " ");
				
			}
			
			catch (EOFException e)
			{
				endOfFile = true;
			}
		}
		    
		//Close the file
		inFile.close();
		System.out.println("\nDone.");
	}
}