// Demonstrate a Linked List using the Mountain class

import java.util.*;

public class MountainLinkedList
{	
	public static void main(String[] args)
	{
		LinkedList<Mountain> mtn = new LinkedList<Mountain>();
				
		// Display the contents in the (empty) list
		System.out.println("Initial contents of (empty) linked list ... " );
		displayListContents( mtn );
			
		// Add items to the list
		System.out.println("Adding several mountains to the list ...");		
		addMtns(mtn);
		
		// Display the list contents after adding several mountains to it
		System.out.println("\nNew contents of mtn linked list ... " );
		displayListContents( mtn );
		
		// Check to see if any of the mountains are the same height
		System.out.println("Inital check for matching heights ...");
		checkForMatchingHeights( mtn );
		
		// Now add another mountain to the list that has the same height
		// as another known mountain in the list
		System.out.println("Adding another mountain to the list ...");
		mtn.add(new Mountain("Magic Mountain", 2030));
		
		// Display the updated list contents
		System.out.println("Updated list contents after adding ...");
		displayListContents( mtn );
		
		// Now check again to see if any of the mountains are the same height
		// -- there should definitely be a match found now)
		System.out.println("Second check for matching heights ...");
		checkForMatchingHeights( mtn );
				
		// Remove item 0 and every 2nd element thereafter
		System.out.println("Removing every 2nd element from the list ...");		
		for (int i = 0; i < mtn.size(); i = i + 2)
		{
			mtn.remove(i);			
		}
		
		// Display the list
		System.out.println("Revised list contents after removing elements ...");
		displayListContents( mtn );
	}	
			

    public static void addMtns(LinkedList<Mountain> mtn)
    {
	    mtn.add(new Mountain("Kilauea", 10228));
	    mtn.add(new Mountain("Mauna Kea", 95784));
	    mtn.add(new Mountain("Mauna Loa", 11234));
	    mtn.add(new Mountain("Haleakala", 87954));
	    mtn.add(new Mountain("Waianae", 3156));
	    mtn.add(new Mountain("Lanai Hale", 2030));	    	    
    }
    
    public static void displayListContents( LinkedList<Mountain> mtn )
    {
    	System.out.println("\nLinked list size is: " + mtn.size());	
    	for (int i = 0; i < mtn.size(); i++)
		{
			System.out.println(mtn.get(i).toString());
		}
		System.out.println();	// just to to make things look nice!
    }
    public static void checkForMatchingHeights( LinkedList<Mountain> mtn)
    {
    	// this routine checks to see if there are any mountains in
    	// the list with matching heights.    	
    	Mountain testMountain;
    	Mountain otherMountain;
    	boolean foundMatchFlag = false;
    	
    	// loop over all elements in the list
    	for( int i = 0; i < mtn.size(); i++)
    	{
    		// get a mountain element from the list at the i-th index
    		testMountain = mtn.get(i);
    		
    		// search the rest of the list for a mountain with the same height
    		// NOTE: don't check the same element so start with element i+1  
    		for( int j = i+1; j < mtn.size(); j++)
    		{
    			otherMountain = mtn.get(j);
    			
    			// call the comparison method
    			if ( testMountain.equalsHeight( otherMountain ) == true )
    			{
    				// set the flag (just for completeness)
    				foundMatchFlag = true;
    				System.out.println("Matching Heights Found!");
    				testMountain.toString();
    				otherMountain.toString();
    			}
    		}
    	}
    	
    	// let the user know if absolutely no matching heights were found
    	if ( foundMatchFlag == false )
    	{
    		System.out.println(" No matching heights found in the list");
    	}
    }
}

