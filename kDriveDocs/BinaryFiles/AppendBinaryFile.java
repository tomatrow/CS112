//This program uses a binary file and writes the contents of an int
//array to the file.
 
import java.io.*;

public class AppendBinaryFile
{
	public static void main(String[] args) throws IOException
	{
		//Create an array of integers
		int[] numbers = { 16, 18, 20, 22, 24, 26, 28, 30};
		
		//Open a binary file for output
		//FileOutputStream fstream =  new FileOutputStream("numbers.dat", true);
		//DataOutputStream outFile = new DataOutputStream(fstream);
		//or
		DataOutputStream outFile = new DataOutputStream(
			                       new FileOutputStream("numbers.dat", true));
		
		System.out.println("Writing to file.");
		
		//Write the array elements to the binary file
		for (int i = 0; i < numbers.length; i++)
		    outFile.writeInt(numbers[i]);
		    
		//Close the file
		outFile.close();
		System.out.println("Done.");
	}
}