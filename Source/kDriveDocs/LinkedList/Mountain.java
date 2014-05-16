// Simple class to be used with the Linked List class in the API

import java.util.*;

public class Mountain
{
	private String name;
	private int height;
	
	public Mountain(String n, int h)
	{
		name = n;
		height = h;	
	}
	
	public void setName(String aName)
	{
		name = aName;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setHeight(int aHeight)
	{
		height = aHeight;
	}
	
	public int getHeight()
	{
		return height;
	}
		
	
	public String toString()
	{
		return ("Name is: " + name + " Height is " +
		                                 height);
	}
	
	public boolean equalsHeight(Mountain otherMtn)
	{
		if (height == otherMtn.height)
			return true;
		else
			return false;						
	}
}