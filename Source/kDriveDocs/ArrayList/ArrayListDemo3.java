// ArrayListDemo3.java
// Non-Generics Example with multiple objects
// This program demonstrates how to use a cast operator
// with the ArrayList class's get method.

import java.util.*;

public class ArrayListDemo3
{
    public static void main(String[] args)
    {
        //create a list to hold Inventory objects
        // don't specify the type of objects
        ArrayList  list = new ArrayList();

        //add three Inventory objects to the ArrayList
        list.add(new Inventory("Hammers", 100));
        list.add(new Inventory("Wrenches", 150));
        list.add(new Inventory("Pliers", 75));
                
        //Display each item
        for (int index = 0; index < 3; index++)
        {
             Inventory item = (Inventory)list.get(index);  //with typecast
             System.out.println("Item at index  " + index +
                                "\nDescription: " + item.getDescription() +
                                "\nUnits: " + item.getUnits());
        }
        System.out.println();
            
        //add three Dog objects to the ArrayList
        list.add(new Dog2("Duke", "Great Dane", 2));
        list.add(new Dog2("Coco", "Labrador", 5));
        list.add(new Dog2("Hanalei", "Collie", 8));
        
        //Display each item
        for (int index = 3; index < list.size(); index++)
        {
             Dog2 theDog = (Dog2)list.get(index);  //with typecast
             System.out.println("Dog at index  " + index +
                                "\nDescription: " + theDog.getName() +
                                "\nBreed: " + theDog.getBreed() +
                                "\nAge: " + theDog.getAge());
        }
        System.out.println();
        
        System.out.println("List's size now = " + list.size());
        System.out.println();
        
        
        // Loop thru list and get all dog indexes
        Object theObject;   // creating a reference variable         
        for(int i = 0; i < list.size(); i++)
        {
        	if( (theObject = list.get(i)) instanceof Dog2)
        	{        	
                System.out.println("Dog at index:" + i);
            }
        }
        System.out.println();

        // Find specific dog, Hanalei, in the list
        for(int i = 0; i < list.size(); i++)
        {
        	theObject = list.get(i);    // get the ith item in the list
        	if(theObject instanceof Dog2)  // test if obj in Dog2 class        	
        	{        	
                Dog2 theDog = (Dog2)theObject;  // is a dog, typecast
                if(theDog.getName() == "Hanalei")
                {               
                System.out.println("Hanalei at index:" + i);
                }
            }
        }
        System.out.println();
        
        // Make new dog 
        Dog2 theDog = new Dog2("Koele Kai", "Collie", 2);
        
        // Place the new dog in between Inventory items 0 and 1 
        list.add ( 1, theDog ); 

        for(int i = 0; i < list.size(); i++)
        {
        	if( (theObject=list.get(i)) instanceof Dog2)
        	{        	
                System.out.println("Dog at index:" + i);
            }
        }        
        System.out.println();
        
        //Display the new dog's data
        //for (int index = 3; index < list.size(); index++)
                     Dog2 newDog = (Dog2)list.get(1);  //with typecast
             System.out.println("Dog at index  1:" +
                                "\nDescription: " + newDog.getName() +
                                "\nBreed: " + newDog.getBreed() +
                                "\nAge: " + newDog.getAge());
        //}
        System.out.println();
        
        System.out.println("What is in the list now?");
        for(int i = 0; i < list.size(); i++)
        {
        	// get the ith item in the list
        	theObject=list.get(i);
        	      
        	// Query the object for its class type        	
        	if(theObject instanceof Dog2)
        	{        	
                System.out.println("Dog at index:" + i);
                Dog2 aDog = (Dog2)theObject; // it is a dog, typecast
                System.out.println("Dog's name is: " + aDog.getName());
            }
            else if(theObject instanceof Inventory)
        	{        	                
                System.out.println("Inventory at index:" + i);
                Inventory anItem = (Inventory)theObject; // it is Inventory
                System.out.println("Item's description is: " 
                                   + anItem.getDescription());
            }
            else
        	{        	
                System.out.println("Invalid object at index:" + i);
            }
            
        }
        System.out.println();
        System.out.println("Final list size is: " + list.size());
        System.out.println();        
    }
}

