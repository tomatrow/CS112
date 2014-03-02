// This program uses the RandomAccessFile class to open the file,
// letters.dat and randomly read letters from different locations.

import java.io.*;

public class ReadRandomAccess
{
	public static void main(String[] args) throws Exception
	{
		final int CHAR_SIZE = 2;           // 2 byte characters read in
		long byteNum;                      // For the byte number (pointer location)
		char ch;                           // To hold a character
		boolean endOfFile = false;         // flag for EOF
		
		// Open the file, letters.dat, for reading
		RandomAccessFile randomFile = new RandomAccessFile("letters.dat", "r");
		
		System.out.println("Reading letters from the file.");
		
		// Move to character 5. This is the sixth character from the 
		// beginning of the file.
		byteNum = CHAR_SIZE * 5;
		randomFile.seek(byteNum);
		
		// Read the character stored at this location and display it.
		// It should be the letter f.
		ch = randomFile.readChar();
		System.out.println(ch);
		
		// Move to character 1. This is the second character from the 
		// beginning of the file. Read and display it.
		byteNum = CHAR_SIZE * 1;
		randomFile.seek(byteNum);
		ch = randomFile.readChar();
		System.out.println(ch);
		    
		// Move to character 0. This is the first character from the 
		// beginning of the file. Read and display it.
		byteNum = CHAR_SIZE * 0;
		randomFile.seek(byteNum);
		ch = randomFile.readChar();
		System.out.println(ch);
				    
		//Close the file
		randomFile.close();
		System.out.println("\nDone.");
	}
}