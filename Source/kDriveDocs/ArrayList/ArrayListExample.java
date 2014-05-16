// ArrayListExample.java
// This program demonstrates using the ArrayList class with no
// Generics. This means that any class object can be stored in 
// the ArrayList. Various methods in the ArrayList class will 
// be tested.
// Since any class datatype can be used in the ArrayList, it 
// also demonstrates that a compiler warning will be issued.

import java.util.*; 
    
public class ArrayListExample
{
   public static void main ( String [  ]  args )
   {           
     // Create new ArrayList Data Structure      
     ArrayList arraylist1 = new ArrayList (  );
     
     // Create new String Array with 5 elements 
     String arr [  ] = { "india","","three",null,"new Integer ( 1 ) "};
     
     // Get the size of the ArrayList at the start
     System.out.println ( "Before adding elements to arraylist1, " +
                          " its size is = " + arraylist1.size (  ));
     System.out.println();                           
      
     //Different ways to Add Elements to the ArrayList
     // 1. Add elements from String Array, arr 
     for ( int i=0;i < arr.length;i++ )  
     {  
       arraylist1.add ( i,arr [ i ] ); 
     }
          
     // Print current Elements of the ArrayList using get() method
     System.out.println ( "After adding 5 elements to the ArrayList, " 
                          +"the elements of arraylist1 are now: ");      
     for ( int i = 0;i < arraylist1.size(  ); i++)  
     {  
       System.out.println (" "+ ( i + 1 ) +" )  "
                           + arraylist1.get ( i ));                            
     }
     System.out.println ( " arraylist1's size is now = " 
                          + arraylist1.size (  ));
     System.out.println();  
      
     // 2. Include more elements using the add() method  
     arraylist1.add ( new Float ( 3.5 )); 
     arraylist1.add ( new StringBuffer ( "IN BUFFER" )); 
     arraylist1.add ( null ); 
     arraylist1.add ( new Float ( 3.5 )); 
     String aa="Software Engineer"; 
     arraylist1.add ( 1,aa ); 
      
     // After adding more elements, print ArrayList
     System.out.println ( "After adding 5 more elements to arraylist1: ");      
     for ( int i = 0;i < arraylist1.size (  ); i++)  
     {  
       System.out.println (" "+ ( i + 1 ) +" )  "
                           + arraylist1.get ( i )); 
     }
  
     // Check the number of elements in the ArrayList
     System.out.println ( "arraylist1's size is now = " 
                          + arraylist1.size (  ));
     System.out.println ( "Notice new placement of elements as Position 1 "
                          +"was changed and all others moved down 1 spot. ");                     
     System.out.println();
          
     // Check to see if there are any elements in the ArrayList                       
     System.out.println ( "The arraylist is Empty? = "
                           + arraylist1.isEmpty (  ));
     System.out.println();                       
      
     // Change the value of element at position one 
     arraylist1.set ( 1,"J2EE Programmer" ); 
      
     // Convert current Object datatype ArrayList to another ArrayList
     System.out.println ( "Using toArray() to create arraylist2 by "
                          +"copying  the elements of arraylist1 " 
                          +"and displaying the results.");
                
     Object list2array [  ]  = arraylist1.toArray (  );
      
     // Print out the elements in the new Array     
     for ( int i=0;i < list2array.length;i++ )  
     {  
       System.out.println ( " "+ ( i + 1 ) +" )  "
                               + list2array [ i ]); 
     }
     System.out.println();
       
     System.out.println("Trying out some more methods of ArrayList class: "); 
     // Check to see if the ArrayList contains a specific element 
     System.out.println ( "Contains \"one\" value = "
                           + arraylist1.contains ( "one" ));
     // Get the Index of the element
     // In this case, it should be -1 as the value is not found
     System.out.println ( "IndexOf \"one\" value = "
                           + arraylist1.indexOf ( "one" ));
     System.out.println();
                           
     // Check to see if the ArrayList contains another specific element                                                                                                                              
     System.out.println ( "Contains \"null\" value = "
                           + arraylist1.contains ( null ));                                        
     // Get the Index of this other object
     // In this case it should be Position 4      
     System.out.println ( "IndexOf \"null\" value = "
                           + arraylist1.indexOf ( null ));
     System.out.println();                      
      
     // Get the Last Occurance of an Object  
     System.out.println ( "LastIndexOf \"new Float ( 3.5 ) \" value = " 
                           + arraylist1.lastIndexOf (new Float ( 3.5 )  ));
     System.out.println();                      
                                
     // Remove an element from the ArrayList and check its new size 
     arraylist1.remove ( 2 ) ; 
     System.out.println ( "After removing 1 element, its size is = "
                          + arraylist1.size (  ));
     System.out.println();                      
          
     // Clear the ArrayList and make sure its size is O
     arraylist1.clear (  ) ; 
     System.out.println ( "After clearing the ArrayList, its size is = "
                           + arraylist1.size (  ));
     System.out.println();                            
    }  
  }  


