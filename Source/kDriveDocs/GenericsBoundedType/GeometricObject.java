// GeometricObject.java - An Abstract Class
// This program creates a class GeometricObject as a model for objects 
// like Rectangles, Circles, Cubes, etc. This class will provide
// properties and behaviors that are common for geometric objects.

public abstract class GeometricObject
{
	private String color = "white";
	private boolean filled;
	private java.util.Date dateCreated;
	
	// Default Constructor
	public GeometricObject()
	{
		dateCreated = new java.util.Date();
	}
	
	// Accessor methods
	public String getColor()
	{
		return color;
	}
	
	public boolean isFilled()
	{
		return filled;
	}
	
	public java.util.Date getDateCreated()
	{
		return dateCreated;
	}
	
	// Mutator methods
	public void setColor(String theColor)
	{
		color = theColor;
	}
	
	public void setFilled(boolean theFill)
	{
		filled = theFill;
	}
		
	// Display GeometricObject info
	public String toString()
	{
		return "Created  on " + dateCreated + "\ncolor: " + color
		                 + " and filled: " + filled;		                		                 
	}
	
	// Abstract Methods
	public abstract double getArea();
	
	public abstract double getPerimeter();
}