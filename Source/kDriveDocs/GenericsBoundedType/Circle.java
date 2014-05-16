// Circle.java
// This program creates a class Circle that extends the GeometricObject
// class. It inherits the methods getColor, setColor, isFilled, setFilled
// and toString.

public class Circle extends GeometricObject
{
	private double radius;
	
	// no-arg Constructor
	public Circle()
	{
	}
	
	//Constructor with one arg
	public Circle(double theRadius)
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
	
	// Display circle info
	public void printCircle()
	{
		System.out.println("The circle is created " + getDateCreated()
		                 + " and the radius is " + radius);
	}
}