// SinglyLinkedList.java
// This program demonstrate the creation of a Linked List 
// class. It creates a singly linked list Data Structure.

public class SinglyLinkedList
{
   private SinglyLinkedListNode head;  // reference to first (head) node

   // constructors
   public SinglyLinkedList()
   {
      head = null;
   }
	
	
   // add node to the top of the list	
   public void AddNode( String theItem, int theNumber )
   {
      head = new SinglyLinkedListNode( theItem, theNumber, head );
   }

   public boolean RemoveNode()
   {
      // remove the top (first) node in the list
      if ( head != null )
      {
         head = head.GetLink(); // reset the head to next node in list
         return( true );
      }
      else
      {
         return( false );      // there are no links left
      }
   }

   public int GetNumNodes()
   {
      int count = 0;
      SinglyLinkedListNode theNode = head;  // start at the top of the list

      // traverse the list until we run out of nodes
      // NOTE: when the node is null we have reached the end of the list
      while ( theNode != null )
      {
         count++;              // increment the number of nodes counter
         theNode = theNode.GetLink();  // move to the next node in list
      }
      return( count );
   }
   
   public boolean Contains( String searchItem )
   {
      SinglyLinkedListNode theNode = null; //create temp node

      theNode = FindNodeInList( searchItem );
      if ( theNode != null )
      {
      	 // found a matching node
         return( true );
      }
      else
      {
      	 // did not find a matching node
         return( false );
      }
   }

   public SinglyLinkedListNode FindNodeInList( String searchItem )
   {
      SinglyLinkedListNode theNode = head;  // start at the top of list
      String theItemName;

      // traverse the list until we run out of nodes
      // NOTE: when the node is null we have reached the end of list
      while( theNode != null )
      {
         theItemName = theNode.GetItemName();
         if ( theItemName.equals( searchItem ) )
         {
            // we found a match !
            return( theNode );
         }
         else
         {
            // go on to the next node in the list
            theNode = theNode.GetLink();
         }
      }
      return( null );  // no matching node was found in the list
   }

   public void OutputLinkedList()
   {
      SinglyLinkedListNode theNode = head;  // start at the top of list
      String theItem;

      // traverse the list until we run out of nodes
      // NOTE: when the node is null we have reached the end of list
      while( theNode != null )
      {
         theNode.OutputNodeToScreen();
         theNode = theNode.GetLink();  // move to next node in list
      }
   }
}