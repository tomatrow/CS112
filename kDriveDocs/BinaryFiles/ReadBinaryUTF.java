//This program opens a binary file, reads and displays
//the contents which are in an String array.

import java.io.*;

public class ReadBinaryUTF
{
	public static void main(String[] args) throws IOException
	{
		String name;
		boolean endOfFile = false;         //flag for EOF
		
		//Open a binary file, strings.dat, for input
		
		//FileInputStream fstream =  new FileInputStream("strings.dat");
		//DataInputStream inFile = new DataInputStream(fstream);
		//or
		DataInputStream inFile = new DataInputStream(
			                     new FileInputStream("strings.dat"));
		
		System.out.println("Reading names from the file.");
		
		//Read data from the file
		while (!endOfFile)
		{
			try
			{
				name = inFile.readUTF();
				System.out.println(name  + " ");
				
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