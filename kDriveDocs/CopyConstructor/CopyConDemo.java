 // This program uses the Stock class's copy constructor 
 // method to create a copy of a Stock object. It uses
 // other class methods to determine if the new object has
 // the same values as the calling object.

public class CopyConDemo
{
   public static void main(String[] args)
   {
      boolean resultStatus;
      
      // Create a Stock object.
      System.out.println("Creating company 1 using the constructor.");
      Stock company1 = new Stock("XYZ", 9.62);
      // Display the object, company1.
      System.out.println("Company 1:\n" + company1);

      // Create another Stock object using the copy constructor.
      System.out.println();
      System.out.println("Creating company 2 from company 1 using the copy constructor. ");
      Stock company2 = new Stock(company1);      
      // Display the contents of company2.
      System.out.println("Company 2:\n" + company2);
      
      // Confirm that we actually have two objects.
      System.out.println();
      System.out.println("Confirm the objects are different.");
      if (company1 == company2)
      {
         System.out.println("The company1 and company2 "
                + "variables reference the same object.");
      }
      else
      {
         System.out.println("The company1 and company2 "
              + "variables reference different objects.\n");
      }
      
      System.out.println("Set new share price for company 2.");
      System.out.println("Are the sharePrices different now?");
      company2.setSharePrice(10.50);
      System.out.println("\nCompany 1:\n" + company1);
      System.out.println();
      System.out.println("Company 2:\n" + company2);
   
      // Are the objects still twins of each other?
      System.out.println();
      System.out.println("Are the companies still twins of each other? ");
      if (company1 == company2)
      {
         System.out.println("The company1 and company2 "
                + "variables reference the same object.");
      }
      else
      {
         System.out.println("The company1 and company2 "
              + "variables reference different objects.\n");
      }
      // Use equals method to see if the contents of both companies are the same
      System.out.println("Are the contents of both companies the same? ");
      resultStatus = company1.equals(company2);
      {
      	if (resultStatus == true)
      	    System.out.println("The company data is the same "
      		+ " for both companies. " + "Status = " + resultStatus);
      	else if (resultStatus == false)
      	    System.out.println("The company data is not the same "
      		+ " for both companies. " + "Status = " + resultStatus);	
      }
      
      // Try the copy method
      System.out.println();
      System.out.println("Creating company3 from company2 using the copy method.");
      Stock company3 = company2.copy();
      // Display the contents of both objects.
      System.out.println("Company 3:\n" + company3);
      
      // Set new share price for company3
      System.out.println();
      System.out.println("Setting new share price for company 3.");
      company3.setSharePrice(12.75);
      System.out.println("Setting new symbol for company 3.");
      company3.setSymbol("ABC");
      System.out.println();
      
      // Try the clone method
      System.out.println("Cloning company4 from company 3.\n");
      Stock company4 = company3.clone();
      // Display the contents of both objects.
      System.out.println("Company 3:\n" + company3);
      System.out.println();
      System.out.println("Company 4:\n" + company4);
      System.out.println();
      
      // Setting new symbol for company3
      System.out.println("Setting new symbol for company 3 - EFG.");
      company3.setSymbol("EFG");
      
      // Assigning company4 to company3 - what happened to EFG?
      System.out.println("Assigning company4 to company3 - what happened to EFG?");
      company3 = company4;
      System.out.println("Company 3:\n" + company3);
      System.out.println();
      System.out.println("Company 4:\n" + company4);
      
      //Get memory location where company3 and company 4 are stored.
	  System.out.println("company 3 is: " + company3);
	  System.out.println("company 4 is: " + company4);

   }
}