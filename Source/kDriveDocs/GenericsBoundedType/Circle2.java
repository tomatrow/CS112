// Circle.java
// This program creates a class Circle that does not extend the 
// GeometricObject class. 

public class Circle2
{
	private double radius;
	
	// no-arg Constructor
	public Circle2()
	{
	}
	
	//Constructor with one arg
	public Circle2(double theRadius)
	{
		radius = theRadius;	
	}
	
	// Accessor method
	public double getRadius()
	{
		return radius;
	}
	
	// Mutator method
	public void setRadius(double theRadius)
	{
		radius = theRadius;
	}
	
	// Find the area
	public double getArea()
	{
		return radius * radius * Math.PI;
	}
	
	// Determine the diameter
	public double getDiameter()
	{
		return 2 * radius;
	}
	
	// Determine the perimeter
	public double getPerimeter()
	{
		return 2 * radius * Math.PI;
	}	
}