//This program demonstrates that an interface type may be used
//to create a polymorphic reference

import java.text.DecimalFormat;

public class PolymorphicInterfaceDemo
{
	public static void main(String[] args)
	{
		CompactDisc cd = new CompactDisc("Greatest Hits", "Joe Loony Band", 18.95);
		                                  
		DvdMovie movie = new DvdMovie("Wheels of Fury", 137, 12.95);
		                                 
		//Display the Prices for each item
		System.out.println("Item 1: " + cd.getTitle());
		showPrice(cd);
		System.out.println("Item 2: " + movie.getTitle());
		showPrice(movie);
		
	}
	
	//showPrice method
	private static void showPrice(InterfaceRetailItem item)
	{
		DecimalFormat dollar = new DecimalFormat("#,###.00");
		System.out.println("Price: $" + dollar.format(item.getRetailPrice()));
	}
}

