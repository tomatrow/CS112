// This program facilitates polymorphism with an Animal super class
// and its derived classes. An array will hold objects of type Animal
// but any subclass of Animal can be placed in the array.

public class AnimalTestDrive
{
	public static void main(String [] ars)
	{
		//Create a polymorphic array where the reference, animals, and 
		//the object are different
		Animal[] animals = new Animal[5];
		animals[0] = new Lion();
		animals[1] = new Wolf();
		animals[2] = new KittyCat();
		animals[3] = new Dog(); 
		animals[4] = new Pig();
		
		//loop through the array and call several of the Animal-class
		//methods - each object will perform correctly!
		for (int i = 0; i < animals.length; i++)
		{
			animals[i].makeNoise();
			animals[i].roam();
		}
		System.out.println();
	}	
}