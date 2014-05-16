//This program demonstrates how to use a cast operator
//with the ArrayList class's get method.

import java.util.ArrayList;

public class ArrayListDemo2
{
    public static void main(String[] args)
    {
        //create a list to hold Inventory objects
        // don't specify the type of objects
        ArrayList  list = new ArrayList();

        //add three Inventory objects to the ArrayList
        list.add(new Inventory("Nuts", 100));
        list.add(new Inventory("Bolts", 150));
        list.add(new Inventory("Washers", 75));

        //Display each item
        for (int index = 0; index < list.size(); index++)
        {
             Inventory item = (Inventory)list.get(index);  //with typecast
             System.out.println("Item at index  " + index +
                                            "\nDescription: " + item.getDescription() +
                                            "\nUnits: " + item.getUnits());
        }
    }
}
