// Demonstrates using some of the methods in the File Class. A File
// object represents the name and path of a file or directory on a
// disk, but it does NOT represent or give you access to the data in
// the file.

import java.util.Scanner;
import java.io.*;

public class FileClassTest
{

   public static void main(String[] args)
   {

      Scanner keyboard = new Scanner(System.in);
          
      // Get the filename
      System.out.println("Enter the filename: ");
      String filename = keyboard.nextLine();
             
      // Make  a File Object representing an existing file
      File file = new File(filename);
      if (file.exists())
          {
          	// Display a message to user
          	System.out.println("The file " + file + " already exists."
          	                   + "It has been recreated with no data.");
          }
          
          else
          {
          	System.out.println("The file, " + file + ", has been created.");
          }
             
		  // Open stream and add data to the file
		  ObjectOutputStream outFile = null;
		  
          try
          {
          	   outFile = new ObjectOutputStream(new FileOutputStream(file));
          	   SomeClass oneObject = new SomeClass(1, (short)15, 'A', "Robert");
               SomeClass anotherObject = new SomeClass(42, (short)8, 'Z', "Vincent");

               outFile.writeObject(oneObject);
               outFile.writeObject(anotherObject);
          }   
          
          catch(IOException e)
          {
          	System.out.println("Error opening the file: " + file);
          	System.exit(0);
          }
                                                  
          // Does file exist?
          System.out.println("Does data.txt exist? " + file.exists());
          
          // Can file be read?
          System.out.println("Can data.txt be read? " + file.canRead());
 
          // Can file be written to?
          System.out.println("Can data.txt be written to? " + file.canWrite());
          
          // Make a new directory
          File dir = new File("Chapter");
          dir.mkdir();
          System.out.println("A new directory called Chapter has been made.");
          System.out.println("Is Chapter a directory? " + dir.isDirectory());
          System.out.println("Is Chapter a file? " + dir.isFile());
                    
          // Get the absolute path of the Chapter directory
          System.out.println("Chapter's absolute path is: " + dir.getAbsolutePath());
          
          // Length of the file          
          System.out.println("File, data.txt, has length of " + file.length() + " bytes.");
 
          
          System.out.println("End of program.");
    }  
}