// This class describes a Pig that inherits from the Animal class

public class Pig extends Animal
{
	// construct an animal
	public Pig()
	{	
	}
	
	// method to make noise
	public void makeNoise()
	{
		System.out.println("I am a Pig - hear me oink!\n");
	}
	
	// method to roam
	public void roam()
	{
		System.out.println("I don't roam. I like to roll in slop.\n");
	}		
}