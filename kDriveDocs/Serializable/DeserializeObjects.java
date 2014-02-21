//This program deserializes the objects in the Objects.dat
//file and stores them in an array.

import java.io.*;

public class DeserializeObjects
{
	public static void main(String[] args) throws Exception
	{
		final int NUM_ITEMS = 3;
		
		//Create the stream objects
		ObjectInputStream inFile = new ObjectInputStream(
			                       new FileInputStream("Objects.dat"));
			                
		//Create an array to hold Inventory objects
		Inventory[] items = new Inventory[NUM_ITEMS];
		
		//Read the serialized objects from the file
		for (int i = 0; i < items.length; i++)
		{
			items[i] = (Inventory) inFile.readObject();
		}
		
		//Close the file
		inFile.close();
		
		//Display the objects
		for (int i = 0; i < items.length; i++)
		{
			System.out.println("Item: " + (i + 1));
			System.out.println("   Description: " +
			                   items[i].getDescription());
			System.out.println("   Units: " +
			                   items[i].getUnits());
		}
	}
}