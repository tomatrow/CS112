/* File Name: OutputTextFileAppend.java
   Programmer:June Porto

   Problem Statement:
   Demonstrate how to output data to a text file.
*/

import java.util.*;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;

public class OutputTextFileAppend
{
   public static void main(String[] args)
   {
      char repeatAnswer = 'Y';
	  Scanner keyboard = new Scanner(System.in);  //Scanner for input
   	
      //Create object(stream) for output using the FileOutputStream class
   	  PrintWriter outputStream = null;
   	  
      try
      {
          outputStream = new PrintWriter(new FileOutputStream("OutputTextFile.txt",true));
      }
      
      //Check to see if file can be created or exists. If not, end program
      catch(FileNotFoundException e)
      {
          System.out.println("Error opening the file dataFile.");
          System.exit(0);
      }
      
      while (  (repeatAnswer == 'Y' || repeatAnswer == 'y'))
      {
      	  System.out.println("Enter the student's first name and press the Enter key");
      	  String firstName = keyboard.next();
      	  System.out.println("Enter the student's last name and press the Enter key");
      	  String lastName = keyboard.next();
      	  String s1 = keyboard.nextLine();
      	  System.out.println("Enter the test scores and press the Enter key");
      	  int test1 = keyboard.nextInt();
          int test2 = keyboard.nextInt();
      
          //Tell user you are writing out to file
          System.out.println("Writing to file.");
          System.out.println("Data entered: " + firstName + 
              " " + lastName + " " + test1 + " " + test2);
      
          //Write out to file
          outputStream.println(firstName + " " + lastName + " " + 
              test1 + " " + test2);
      
          // prompt the user to continue
   	      System.out.println("\nWould you like to continue?");
   	      System.out.println("Enter 'y' for yes or n for 'no'");
   	      repeatAnswer = keyboard.next().charAt(0);
      }

      
      //Close output file
      outputStream.close();
      
      System.out.println("End of program.");
   }
}