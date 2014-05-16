// Point.java
// Example of writing one's own Generic class and methods
// The Point class holds X and Y coordinates. The data type
// of the coordinates is generic.

public class Point<T>
{
   private T xCoordinate;  // The X coordinate
   private T yCoordinate;  // The Y coordinate
   
   // Constructor
   public Point(T x, T y)
   {
      xCoordinate = x;
      yCoordinate = y;
   }
   
   // Set X coordinate
   public void setX(T x)
   {
      xCoordinate = x;
   }

   // Set Y coordinate
   public void setY(T y)
   {
      yCoordinate = y;
   }

   // Returns value of X coordinate
   public T getX()
   {
      return xCoordinate;
   }

   // Returns value of Y coordinate   
   public T getY()
   {
      return yCoordinate;
   }
}