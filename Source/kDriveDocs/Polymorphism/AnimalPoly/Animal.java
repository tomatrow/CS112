// This class describes an Animal

public class Animal
{
	String name, picture, food;
	int size;
	
	// construct an animal
	public Animal()
	{	
	}
	
	// method to make noise
	public void makeNoise()
	{
		System.out.println("I am an animal");		
	}
	
	// method to roam
	public void roam()
	{
		System.out.println("Depending on who I am, my roam method is different.");
	}	
}