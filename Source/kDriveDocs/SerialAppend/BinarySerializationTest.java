// BinarySerializationTest.java
// This program demonstrates how to append data using binary I/O and
// serialization to a file that contains pre-existing data. Java binary files
// contain a header that is (automatically) written that contains information
// about the object types and object references in the file. Attempting to
// append new data to the file can cause problems since the header is NOT
// automatically updated to account for any new appended data.
// NOTE: 'Normally' ObjectOuputStream() does NOT allow appending new data to an
//        existing file, so the trick here is to rewrite the header to 'update'
//        it so that it will account for both the existing data previously
//        written to the file as well as any new new data that will be written
//        to the file.   

import java.io.*;
import java.text.DecimalFormat;

public class BinarySerializationTest implements Serializable
{
   public static void main( String[]args) throws IOException,
                                                 ClassNotFoundException
   {
      // Declare an array of objects
      TestObject[] objectArray = new TestObject[7];

      // Create a few new objects
      System.out.println( "Creating four new objects ... \n" ); 
      objectArray[0] = new TestObject( 1, "first" );
      objectArray[1] = new TestObject( 2, "second" );
      objectArray[2] = new TestObject( 3, "third" );
      objectArray[3] = new TestObject( 4, "fourth" );

      // Create the output file stream (writes to a file named test.dat)
      // NOTE: when first writing to a new output file, do NOT use the 
      //       'append' flag when invoking the FileOutputStream()
      System.out.println( "Opening a binary file named 'test.dat' ... \n" ); 
      ObjectOutputStream outFile =
                      new ObjectOutputStream( new FileOutputStream("test.dat"));

      // write the objects to file
      outFile.writeObject( objectArray[0] );
      outFile.writeObject( objectArray[1] );
      outFile.writeObject( objectArray[2] );
      outFile.writeObject( objectArray[3] );
      
      // close the file
      System.out.println( "Closing the file 'test.dat' ... \n" ); 
      outFile.close();

      // create three more objects
      System.out.println( "Creating three new objects ... \n" ); 
      TestObject object5 = new TestObject( 5, "fifth" );
      TestObject object6 = new TestObject( 6, "sixth" );
      TestObject object7 = new TestObject( 7, "seventh" );

      // (Re)open the output file stream (writes to a file named test.dat)
      // using our extended AppendOutputObjectStream() class
      // NOTE: when first writing to an existing file that already contains data
      //       it IS necessary to use the 'append' flag when invoking the
      //       FileOutputStream() in the open statement
      // NOTE: the AppendObjectOutputStream() class can be called anytime the 
      //       user needs to append data to an existing file that already
      //       contains data 
      System.out.println( "Re-opening the (existing) file 'test.dat' ... \n" ); 
      AppendObjectOutputStream appendedOutFile = 
           new AppendObjectOutputStream( new FileOutputStream("test.dat",true));

      // Append (write) the three new objects to the file
      System.out.println( "Writing 3 new objects to file 'test.dat' ... \n" ); 
      appendedOutFile.writeObject( object5 );
      appendedOutFile.writeObject( object6 );
      appendedOutFile.writeObject( object7 );
    
      // Close the file
      System.out.println( "Closing the (existing) file 'test.dat' ... \n" ); 
      appendedOutFile.close();

      // Reopen the file for reading
      System.out.println( "Opening the file 'test.dat' ... \n" ); 
      ObjectInputStream inFile =
                        new ObjectInputStream( new FileInputStream("test.dat"));

      // Read all of the data from the file 
      System.out.println( "The objects read from file are as follows: ... \n" ); 
      int count = 1;  // 1-based counter to keep track of objects read from file
      try
      {
         // Reading until end of file
         while( true )
         {            
            // NOTE: cast the input to the 'known' data type
            TestObject tempObject = (TestObject) inFile.readObject();
            System.out.println( "Object " + count + "\n" ); 
            System.out.println( tempObject); 

            count++;    // increment the counter
         }
      }
      catch(EOFException e)
      {
         System.out.println( "Finished reading all objects from file" );
      }

      // Close the file
      inFile.close();
   }
}



