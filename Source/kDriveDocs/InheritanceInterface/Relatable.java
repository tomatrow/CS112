// The purpose of an Interface is to specify behavior for other classes.
// It has all abstract methods (with no bodies) and cannot be instantiated.
// A class that implements this interface must provide all the methods
// listed below. The methods must include the same signatures and the same 
// return types as specified.

// This interface is intended to be used with the GradedActivity class.


public interface Relatable
{
	// Notice that no access specifier is used with the method headers 
	// as all methods specifed by an Interface are public.
	boolean equals(GradedActivity g);
	boolean isGreater(GradedActivity g);
	boolean isLess(GradedActivity g);
}