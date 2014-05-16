// Demonstration of an Array List with a RemoveRange() method

import java.util.*;

public class ArrayListTest extends ArrayList
// must extend ArrayList class to use methods in ArrayList class
{	
	public static void main(String[] args)
	{
		String[] data = {"Zero", "One", "Two", "Three", "Four",
		                 "Five", "Six", "Seven", "Eight", "Nine"};
		                 
		ArrayListTest list = new ArrayListTest();
		
		for (int i = 0; i <data.length; i++)
		{
			list.add(data[i]);			
		}
		
		for (int i = 0; i <list.size(); i++)
		{
			System.out.println("list["+i+"] = "+list.get(i));				
		}					
		
		list.removeRange(2,5);   // does not include last element in range
		
		for (int i = 0; i <list.size(); i++)
		{
			System.out.println("list["+i+"] = "+list.get(i));				
		}					
	}
	
	public void removeRange(int start, int end)
	{
		System.out.println("\nRemoving("+ start+ " - " +(end - 1)+ ")");
		System.out.println("Does not include the end element in the removal.");
		if (start < end - 1)
		{
			super.removeRange(start,end);			
		}		
	}
}