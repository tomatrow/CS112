 // This class demonstrates the use of an innner class.

import java.text.DecimalFormat;

public class RetailItem
{
   private String description;  // Item description
   private int itemNumber;      // Item number
   private CostData cost;       // Cost data

   
   // RetailItem class constructor
   public RetailItem(String desc, int itemNum, 
                     double wholesale, double retail)
   {
      description = desc;
      itemNumber = itemNum;
      cost = new CostData(wholesale, retail);
   }

   // RetailItem class toString method 
   public String toString()
   {
      String str;  // To hold a descriptive string.
      
      // Create a DecimalFormat object to format output.
      DecimalFormat dollar = new DecimalFormat("#,###0.00");

      // Create a string describing the item.
      str = "Description: " + description
          + "\nItem Number: " + itemNumber
          + "\nWholesale Cost: $" 
          + dollar.format(cost.wholesale)
          + "\nRetail Price: $" 
          + dollar.format(cost.retail);
      
      // Return the string.
      return str;
   }

   // CostData Inner Class
   private class CostData
   {
      public double wholesale,  // Wholesale cost
                    retail;     // Retail price

      /**
       * CostData class constructor 
       */

      public CostData(double w, double r)
      {
         wholesale = w;
         retail = r;
      }
   }
}