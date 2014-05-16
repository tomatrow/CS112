// BoundedGeoTypeDemo
// This program demonstrates the use of a bounded generic type. It tests to 
// see whether two geometric objects have the same area. The bounded generic 
// type <E extends Geometric Object> specifies that E is a generic subtype of 
// GeometricObject. You invoke the equalArea() method by passing two instances
// of Geometric Object.

public class BoundedGeoTypeDemo 
{
    public static void main(String[] args)
    {
        Rectangle rec1 = new Rectangle(2,2);
        Rectangle rec2 = new Rectangle(4,4);
        Rectangle rec3 = new Rectangle(2,2);
        
        System.out.println("Same area - rec1/rec2? " + equalArea(rec1, rec2));
        System.out.println("Same area - rec2/rec3? " + equalArea(rec2, rec3));
        System.out.println("Same area - rec1/rec3? " + equalArea(rec1, rec3));
        
        Circle circ1 = new Circle(5);
        Circle circ2 = new Circle(10);
        
        System.out.println("\nSame area - circ1/circ2? " + 
                              equalArea(circ1, circ2));
        
        Circle2 circ2A = new Circle2(5);
        Circle2 circ2B = new Circle2(10);
        
        //Uncomment & try to run a class that does not extend GeometricObject
        //System.out.println("\nSame area - circ2A/circ2B? " + 
        //                                equalArea(circ2A, circ2B));
        //System.out.println();                           
    }
    
    public static <E extends GeometricObject> boolean equalArea(
                                                       E object1, E object2)
    {
        return object1.getArea() == object2.getArea();
    }
}     
