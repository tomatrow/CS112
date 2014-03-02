// This class facilitates polymorphism. Using the super class
// Animal as a parameter, it is the actual animal that is passed
// as an argument at run-time that will get the shot from the Vet.

public class Vet
{
	public void giveShot(Animal a)
	{
		// give the shot to the animal at the other end of
		// the 'a' parameter.
		a.makeNoise();
	}
}