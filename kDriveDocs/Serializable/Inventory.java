//This class holds simple data about an item in an inventory.

import java.io.Serializable;

public class Inventory implements Serializable
{
	private String description;
	private int units;
	
	//No-arg constructor
	public Inventory()
	{
		description = "";
		units = 0;
	}
	
	//This constructor accepts a String argument which is
	//assigned to the description field.
	 public Inventory(String d)
	 {
	 	description = d;
	 	units = 0;
	 }
	 
	 //This constructor accepts a String argument which is
	 //assigned to the description field and an int argument
	 //which is assigned to the units field.
	 public Inventory(String d, int u)
	 {
	 	description = d;
	 	units = u;
	 }
	 
	 //This constructor accepts an int argument
	 //which is assigned to the units field.
	 public Inventory(int u)
	 {
	 	units = u;
	 }
	 
	 public void setDescription(String d)
	 {
	 	description = d;
	 }
	 
	 public void setUnits(int u)
	 {
	 	units = u;
	 }
	 
	 public String getDescription()
	 {
	 	return description;
	 }
	 
	 public int getUnits()
	 {
	 	return units;
	 }
}