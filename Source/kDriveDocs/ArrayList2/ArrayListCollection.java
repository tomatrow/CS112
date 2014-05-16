
import java.util.ArrayList;

public class ArrayListCollection
{
	public static void main( String[] args )
	{
		// Create a new ArrayList of Strings
		ArrayList< String > items = new ArrayList< String >();
		
		items.add( "red" );  // append an item to the list
		items.add( 0, "yellow" );  // add an new item & insert at index 0
		
		// header
		System.out.print("Display list contents with counter-controlled loop:");
		
		// display the colors in the list
		for (int i = 0; i < items.size(); i++)
		    System.out.printf(" %s", items.get(i));
		    
		// display colors using foreach (enhanced for loop) in display method
		display(items,"\ndisplay list contents with enhanced for statement:");
		
		items.add( "green" );
		items.add( "yellow" );
		display(items, "List with two new elements: ");
		
		items.remove( "yellow");  // removes the first instance of yellow
		display(items, "Remove first instance of yellow: ");
		
		items.remove(1);  // remove 2nd item in list (green)
		display(items, "Remove second list element (green):");
		
		// check to see if value is in the list
		System.out.printf( "\"red\" is %sin the list\n",
		    items.contains( "red") ? "": "not " );
		    
		// display number of elements in the list
		System.out.printf( "Size: %s\n", items.size() );        
	}
	
	// display the ArrayList's elements on the console
	public static void display( ArrayList<String> items, String header)
	{
		System.out.printf( header );  // display header
		
		//display each element in items
		for (String item : items)
		    System.out.printf( " %s", item);
		    System.out.println();  // display end of line    
	}
}