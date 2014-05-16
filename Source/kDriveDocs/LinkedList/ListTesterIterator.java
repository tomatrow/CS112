// This code sample demonstrates inserting strings into a list and 
// then iterating through the list, adding and removing elements.

import java.util.LinkedList;
import java.util.ListIterator;

public class ListTesterIterator
{
   public static void main(String[] args)
   {
   	   LinkedList<String> staff = new LinkedList<String>();
   	   staff.addLast("Motaz");
   	   staff.addLast("Juno");
   	   staff.addLast("Stephen");
       staff.addLast("Annika");
       
       //Who's in at this point?
       System.out.println("Who's in at this first point?");
       for (String name : staff)
           System.out.println(name);
       System.out.println();
           
       // move down the list 2 nodes    
       ListIterator<String> iterator = staff.listIterator();
       iterator.next();            //M|JSA
       iterator.next();            //MJ|SA
       
       // add more elements after the second element
       iterator.add("Rami");      //MJR|SA
       iterator.add("Andy");      //MJRA|SA
       iterator.add("Josh");        //MJRAJ|SA
       
       //Who's in at this point?
       System.out.println("Who's in at this second point?");
       for (String name : staff)
           System.out.println(name);
       System.out.println();
       
       // move down another node  
       iterator.next();             //MJRAJS|A
       
       // remove last traversed element (S)
       iterator.remove();
       
       //Print all elements
       System.out.println("Who's left at this third point?");
       for (String name : staff)
           System.out.println(name);
    }       
}           
           
           
       

