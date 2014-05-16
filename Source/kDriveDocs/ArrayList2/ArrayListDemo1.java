// This program demonstrates the use of the ArrayList class by
// 1) creating an ArrayList to store double-precision objects
// 2) allowing the user to enter any number of objects into the ArrayList
// 3) writing the ArrayList contents to the screen
// 4) calculating and outputing the average, minimum, and maximum values

import java.util.*;

public class ArrayListDemo1
{	
   public static void main(String[] args)
   {
      int index;
      int numItems;
      double tempDouble;
      double avg;
      double maxValue, minValue;
      String answer;
      Scanner keyboard = new Scanner(System.in);

      // create an ArrayList of double-precision objects
      ArrayList <Double> myArrayList = new ArrayList <Double>();

      System.out.println("Starting ArrayList demo ...");

      index = 0;
      do
      {
         System.out.println("Enter value[" + index + "] :");
         tempDouble = keyboard.nextDouble();

         // add this value into the ArrayList
         myArrayList.add( tempDouble );

         index++;// increment the index

         // prompt the user to continue or stop
         System.out.println("Do you want to enter another number? (yes/no)");

         answer = keyboard.next();


      } while( answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y") );


      // output the contents of the ArrayList to the screen 
      numItems = myArrayList.size();
      for ( index = 0; index < numItems; index++ )
      {
         tempDouble = myArrayList.get(index);
         System.out.println("myArrayList value[" + index + "] = " + tempDouble);

      }

      // calculate the average (mean) of the values in the ArrayList
      avg = CalculateAverage( myArrayList );
      System.out.println("the average (mean) value in the ArrayList is " + avg);

      // find the minimum value of in the ArrayList
      minValue = FindMinimumValue( myArrayList );
      System.out.println("the minimum value in the ArrayList is " + minValue);

      // find the maximum value of in the the ArrayList
      maxValue = FindMaximumValue( myArrayList );
      System.out.println("the maximum value in the myArrayList is " + maxValue);

      System.out.println("End of ArrayList demo program.");

   }
   public static double CalculateAverage( ArrayList <Double> theArrayList )
   {
      double sum = 0.0;  // make sure to initialize to zero!
      int numItems;

      numItems = theArrayList.size();

      // just return if the ArrayList is 'empty'
      if ( numItems == 0 )
      {
         return 0.0;
      }

      // loop over all items in the ArrayList
      // NOTE: use a 'for-each' loop (special type of 'for loop' for ArrayLists)

      for ( Double element : theArrayList )
      {
         sum += element;  // element is the i-th double value in the ArrayList
      }
      // we don't have to check the divisor (numItems) to prevent divide by zero
      // because we already checked for this case above

      return ( sum / numItems );
   }

   public static double FindMinimumValue( ArrayList <Double> theArrayList )
   {
      double minValue = 0.0;
      int numItems;

      numItems = theArrayList.size();

      // just return if the ArrayList is 'empty'
      if ( numItems == 0 )
      {
         return 0.0;  // this is the best we can do in this case
      }

      // loop over all items in the ArrayList
      // NOTE: use a 'for-each' loop (special type of 'for loop' for ArrayLists)

      // start the seach by initializing with the value of the first element
      minValue = theArrayList.get( 0 );

      for ( Double element : theArrayList )
      {
         // element is the i-th double value in the ArrayList
         if ( element < minValue )
         {
            minValue = element;  // update the maximum value
         }
      }
      
      return ( minValue );
   }

   public static double FindMaximumValue( ArrayList <Double> theArrayList )
   {
      double maxValue = 0.0;
      int numItems;

      numItems = theArrayList.size();

      // just return if the ArrayList is 'empty'
      if ( numItems == 0 )
      {
         return 0.0;  // this is the best we can do in this case
      }

      // loop over all items in the ArrayList
      // NOTE: use a 'for-each' loop (special type of 'for loop' for ArrayLists)

      // start the seach by initializing with the value of the first element
      maxValue = theArrayList.get( 0 );

      for ( Double element : theArrayList )
      {
         // element is the i-th double value in the ArrayList
         if ( element > maxValue )
         {
            maxValue = element;  // update the maximum value
         }
      }

      return ( maxValue );
   }

}

