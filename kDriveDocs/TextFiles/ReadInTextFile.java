/* File Name: ReadInTextFile.java
   Programmer:June Porto

   Problem Statement:
   Demonstrate how to use the read in information from a text file.
*/

import java.util.*;   //includes Scanner
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ReadInTextFile
{
   public static void main(String[] args)
   {
      //Create object(stream) for input using the FileInputStream class
	  Scanner inputStream = null;
	   
      try
      {
          inputStream = new Scanner(new FileInputStream("readFile.txt"));
      }
      
      catch(FileNotFoundException e)
      {
          System.out.println("File readFile.txt was not found");
          System.out.println("or could not be opened");
          System.exit(0);
      }
      
      System.out.println("Reading in four numbers and a line of text");
      System.out.println("from the file readFile.txt.");
      
      //Get data from file
      int num1 = inputStream.nextInt();
      int num2 = inputStream.nextInt();
      int num3 = inputStream.nextInt();
      int num4 = inputStream.nextInt();
      
      String line;
      line = inputStream.nextLine();  //read end of line character
      line = inputStream.nextLine();
      
      //Display data in the file to monitor
      System.out.println("The four numbers read from the file are;");
      System.out.println(num1 + " " + num2 + " " + num3 + " " + num4);

      System.out.println("The line read from the file is:");
      System.out.println(line);
      
      //Close the input File
      inputStream.close();
      
  }
}

//End of program