// This program uses a Random AccessFile object to create the file
// letters.dat. The letters of the alphabet are written to the file.
// Note: chars in Java are stored in 2 bytes, ints in 4 and doubles in 8 bytes.

import java.io.RandomAccessFile;

public class WriteRandomAccess
{
	public static void main(String[] args) throws Exception 
	{
		// Create an array for the first six letters of the alphabet
		char[] letters = { 'a', 'b', 'c', 'd', 'e', 'f'};
		
		// Open a file for reading and writing.
		RandomAccessFile randomFile = new RandomAccessFile("letters.dat", "rw");	                         
			                         
		// Notify user that program is writing to a file
		System.out.println("Writing to file.");
		
		// Sequentially write the letters array to the file.
		// writeChar method stores letters as two-byte characters.
		for (int i = 0; i < letters.length; i++)
		    randomFile.writeChar(letters[i]);
		    
		// Close the file
		randomFile.close();
		System.out.println("Done.");
	}
}