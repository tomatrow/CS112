// Rectangle.java
// This program creates a class Rectangle that extends the Geometric
// Object class. It inherits the methods getColor, setColor, isFilled, 
// setFilled and toString.

public class Rectangle extends GeometricObject
{
	private double width;
	private double height;
	
	// no-arg Constructor
	public Rectangle()
	{
	}
	
	//Constructor with two args
	public Rectangle(double theWidth, double theHeight)
	{
		width = theWidth;
		height = theHeight;
	}
	
	// Accessor methods
	public double getWidth()
	{
		return width;
	}
	
	public double getHeight()
	{
		return height;
	}
	
	// Mutator methods
	public void setWidth(double theWidth)
	{
		width = theWidth;
	}
	
	public void setHeight(double theHeight)
	{
		height = theHeight;
	}
	
	// Find the area
	public double getArea()
	{
		return width * height;
	}
	
	// Determine the perimeter
	public double getPerimeter()
	{
		return 2 * (width + height);
	}
}