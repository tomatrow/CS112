// TestGeometricObjects.java
// This program creates objects of the Rectangle, Circle and
// Circle2 classes and invokes methods on these objects.
// The GeometricObject class itself is an abstract class, so
// objects cannot be instantiated for that class.
// Also notice that the Circle2 class does not extend the 
// GeometricObject class so methods in that class cannot
// be accessed by a Circle2 object.

public class TestGeometricObjects
{
	public static void main(String[] args)
	{
		// Create some objects
		Rectangle rec = new Rectangle(2,4);
		Circle circ = new Circle(5);
		Circle2 circ2 = new Circle2();
		
		// Test the circle object
		circ.setColor("BLUE");
		System.out.println("\nA Circle " + circ.toString());
		System.out.println("The radius is: " + circ.getRadius());
		System.out.println("The area is " + circ.getArea());
		System.out.println("The diameter is " + circ.getDiameter());
		
		// Test the rectangle object
		rec.setColor("YELLOW");
		System.out.println("\nA Rectangle " + rec.toString());
		System.out.println("The area is " + rec.getArea());
		System.out.println("The perimeter is " + rec.getPerimeter());
		System.out.println("The rectangle was created on: " + 
		                        rec.getDateCreated());
		
		// Test the circle2 object - not a geometric object so doesn't have
		// all the same methods as the circ does.
		circ2.setRadius(10);
		circ2.setColor("GREEN");   // no such method
		System.out.println("\nA Circle " + circ2.toString());  // gets address
		System.out.println("The radius is: " + circ2.getRadius());
		System.out.println("The area is " + circ2.getArea());
		System.out.println("The diameter is " + circ2.getDiameter());

		                        
		                        
	}
}