/* File Name: OutputTextFile.java
   Programmer:June Porto

   Problem Statement:
   Demonstrate how to output data to a text file.
*/

import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;

public class OutputTextFile
{
   public static void main(String[] args)
   {
      //Create object(stream) for output using the FileOutputStream class
   	  PrintWriter outputStream = null;
   	  
      try
      {
          outputStream = new PrintWriter(new FileOutputStream("dataFile.txt"));
      }
      
      //Check to see if file can be created or exists. If not, end program
      catch(FileNotFoundException e)
      {
          System.out.println("Error opening the file dataFile.");
          System.exit(0);
      }
      
      
      //Tell user you are writing out to file
      System.out.println("Writing to file.");
      
      //Write out to file
      outputStream.println("It is a good day for a balloon ride!");
      outputStream.println("The discount cost, today only, is $75.");
      
      //Close output file
      outputStream.close();
      
      System.out.println("End of program.");
   }
}