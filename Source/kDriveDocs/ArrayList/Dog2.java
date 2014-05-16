// Dog2.java
// Designed to work with Inventory class in ArrayListDemo3
import java.util.*;

public class Dog2 
{
	// Instance Variables
	private String name;
	private String breed;
	private String color;
	private String gender;
	private int age;
	private int size;
	private int dogYears;
	
	Scanner keyboard = new Scanner(System.in);
	
	// No-arg constructor
	public Dog2()
	{
		name = "";
		breed = "";
		age = 0;
	}
	
	// Constructor accepting three fields
	public Dog2(String theName, String theBreed, int theAge)
	{
	 	name = theName;
	 	breed = theBreed;
	 	age = theAge;
	}
	
	public void setName()
	{
		System.out.println("Enter the dog's name:");
		name = keyboard.nextLine();
	}
	
	public void setBreed()
	{
		System.out.println("Enter the dog's breed:");
		breed = keyboard.nextLine();
	}
	
	public void setAge()
	{
		System.out.println("Enter the dog's age:");
		age = keyboard.nextInt();
	}
	
	public int dogAge()
	{
		dogYears = age * 7;
		return dogYears;
	}
	
	public String getName()
	{
		return name;
	}
		
	public String getBreed()
	{
		return breed;
	}
		
	public int getAge()
	{
		return age;
	}
	 
	void highFive()
    {
		System.out.println("Slap right paws!");
    }
	void usurpToy()
    {
		System.out.println("Grab toy from sister!");
    }
	void stealBiscuits()
	{
		System.out.println("Raid sister's bowl when she isn't looking!");
    }
    void rollOver()
	{
		System.out.println("Roll body over and over!");
	}
}