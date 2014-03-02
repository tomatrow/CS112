// TestObject.java
// This is a simple class to demonstrate the use of binary I/O, appending 
// to a file using serializtion

import java.io.*;

public class TestObject implements Serializable
{
   private int myInteger;
   private String myString;

   // basic no-arg constructor
   public TestObject()
   {
      myInteger = 0;
      myString = "abc";
   }

   // two-arg constructor
   public TestObject( int theInt, String theString )
   {
      myInteger = theInt;
      myString = theString;
   }

   // getters and setters
   public int GetMyInteger()
   {
      return( myInteger );
   }

   public String GetMyString()
   {
      return( myString );
   }

   public void SetMyInteger( int theInteger )
   {
      myInteger = theInteger;
   }

   public void SetMyString( String theString )
   {
      myString = theString;
   }

   public String toString()
   {
      return( "myInteger: " + myInteger + "\n" + 
              "myString: " + myString + "\n" );
   }

   public boolean equals( TestObject other )
   {
      if ( myInteger == other.GetMyInteger() && myString == other.GetMyString() )
      {
         return( true );
      }
      else
      {
         return( false );
      }
   }
}
