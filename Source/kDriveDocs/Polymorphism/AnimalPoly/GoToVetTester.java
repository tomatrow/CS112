// This program demonstrates polymorphism. Using the super class
// Animal as a parameter in the Vet class, it is the actual animal
// that is passed as an argument to the Vet's giveShot() method 
// that will get the shot from the Vet.

public class GoToVetTester
{
	public static void main(String [] ars)
	{
		//Instantiate a Vet, a Dog, a Wolf and a Pig object
		Vet v = new Vet();
		
		Dog  d = new Dog();
		Wolf w = new Wolf();
		Pig  p = new Pig();
		
		// give a shot to the animal objects - do they
		// make the right noise when they receive the shot?
		v.giveShot(d);
		v.giveShot(w);
		v.giveShot(p);		    
	}
}