// SinglyLinkedListNode.java
// This program creates a class for the nodes that will be used
// in the SinglyLinkedList class.

public class SinglyLinkedListNode
{
   private SinglyLinkedListNode linkToNextNode;  // reference to next node
   private int itemNumber;
   private String itemName;


   // constructors
   public SinglyLinkedListNode()
   {
      linkToNextNode = null;
      itemName = null;
      itemNumber = 0;
   }

   public SinglyLinkedListNode( String theItem, int theNumber,
                                SinglyLinkedListNode theNode )

   {
      SetNodeData( theItem, theNumber );
      linkToNextNode = theNode;
   }

   public void SetNodeData( String theItem, int theNumber )
   {
      itemName = theItem;
      itemNumber = theNumber;
   }

   public String GetItemName()
   {
      return( itemName );
   }


   public int GetItemNumber()
   {
      return( itemNumber );
   }
   
   public SinglyLinkedListNode GetLink()
   {
      return( linkToNextNode );
   }

   public void OutputNodeToScreen()
   {
      System.out.println("Item Name: " + itemName );
      System.out.println("Item Number: " + itemNumber );
   }
}