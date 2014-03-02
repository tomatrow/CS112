//This program uses a binary file and writes the contents of a String
//array to the file.

import java.io.*;

public class WriteBinaryUTF
{
	public static void main(String[] args) throws IOException
	{
		//Create an array of integers
		String[] names = {"Matt", "Malia", "Nathan", "Barbara", "Travis"};
		
		//Open a binary file for output
		//FileOutputStream fstream =  new FileOutputStream("strings.dat");
		//DataOutputStream outFile = new DataOutputStream(fstream);
		//or
		DataOutputStream outFile = new DataOutputStream(
			                         new FileOutputStream("strings.dat"));
		
		System.out.println("Writing to file.");
		
		//Write the array elements to the binary file
		for (int i = 0; i < names.length; i++)
		    outFile.writeUTF(names[i]);
		    
		//Close the file
		outFile.close();
		System.out.println("Done.");
	}
}