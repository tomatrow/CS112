// SinglyLinkedListTestDriver.java
// This program demonstrates an implementation of a simple
// SinglyLinkedList class and the SinglyLinkedListNode class.

public class SinglyLinkedListTestDriver
{
   public static void main( String[] args )
   {
      SinglyLinkedList myList = new SinglyLinkedList();// create new list
      int numNodes;
      String searchString;

      // add a few nodes to the list
      myList.AddNode("Dog", 451 );

      myList.AddNode("Cat", 306 );

      myList.AddNode("Horse", 22 );

      myList.AddNode("Tiger", 528 );

      // output the contents of the list to the screen
      numNodes = myList.GetNumNodes();
      System.out.println("the list has " + numNodes + " nodes" );
      myList.OutputLinkedList();

      // search the list for a few items
      searchString = "Zebra";
      if ( myList.Contains(searchString) )
      {
         System.out.println( searchString + " is on the list!" );
      }
      else
      {
         System.out.println( searchString + " is NOT on the list!" );
      }

      searchString = "Dog";
      if ( myList.Contains(searchString) )
      {
         System.out.println( searchString + " is on the list!" );
      }
      else
      {
         System.out.println( searchString + " is NOT on the list!" );
      }

      searchString = "Cat";
      if ( myList.Contains(searchString) )
      {
         System.out.println( searchString + " is on the list!" );
      }
      else
      {
         System.out.println( searchString + " is NOT on the list!" );
      }

      // remove the top node from the list
      myList.RemoveNode();

      // output the new list to the screen
      System.out.println(" ...after removing the top node from list...");
      numNodes = myList.GetNumNodes();
      System.out.println("the list has " + numNodes + " nodes" );
      myList.OutputLinkedList();

      // now add another node to top of the list; push down on the stack
      myList.AddNode("Lion", 41 );

      // output the new list to the screen
      System.out.println(" ...after adding another node to list...");
      numNodes = myList.GetNumNodes();
      System.out.println("the list has " + numNodes + " nodes" );
      myList.OutputLinkedList();

      System.out.println();
      System.out.println("That's all folks ..." );

   }
}