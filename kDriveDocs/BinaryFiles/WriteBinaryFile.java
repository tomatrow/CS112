//This program uses a binary file and writes the contents of an int
//array to the file.

import java.io.*;

public class WriteBinaryFile
{
	public static void main(String[] args) throws IOException
	{
		//Create an array of integers
		int[] numbers = { 2, 4, 6, 8, 10, 12, 14};
		
		//Open a binary file for output
		//FileOutputStream fstream =  new FileOutputStream("numbers.dat");
		//DataOutputStream outFile = new DataOutputStream(fstream);
		//or
		DataOutputStream outFile = new DataOutputStream(
			                         new FileOutputStream("numbers.dat"));
		
		System.out.println("Writing to file.");
		
		//Write the array elements to the binary file
		for (int i = 0; i < numbers.length; i++)
		    outFile.writeInt(numbers[i]);
		    
		//Close the file
		outFile.close();
		System.out.println("Done.");
	}
}