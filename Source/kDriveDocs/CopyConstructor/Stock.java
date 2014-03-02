// The Stock class holds data about a stock and includes a      
// copy constructor for performing a deep copy.

public class Stock
{
   private String symbol;     // Trading symbol of stock
   private double sharePrice; // Current price per share

   // The constructor accepts arguments for the      
   // stock's trading symbol and share price.
   public Stock(String sym, double price)
   {
      symbol = sym;
      sharePrice = price;
   }
   
   // Copy constructor 
   public Stock(Stock otherObject)
   {
      symbol = otherObject.symbol;
      sharePrice = otherObject.sharePrice;
   }
  
   // getSymbol method 
   public String getSymbol()
   {
      return symbol;
   }
    
   // getSharePrice method
   public double getSharePrice()
   {
      return sharePrice;
   }
   
   // setSharePrice method
   public double setSharePrice(double price)
   {
   	return sharePrice = price;
   }
       
   // setSymbol method
   public String setSymbol(String sym)
   {
      symbol = sym;
      return symbol;
   }

   //toString method
   public String toString()
   {
      // Create a string describing the stock.
      String str = "Trading symbol: " + symbol
                   + "\nShare price: " + sharePrice;
      
      // Return the string.
      return str;
   }

   // equals method
   public boolean equals(Stock object2)
   {
      boolean status = false;
      
      // Determine whether this object's symbol and
      // sharePrice fields are equal to object2's
      // symbol and sharePrice fields.
      if (symbol.equals(object2.symbol) &&
          sharePrice == object2.sharePrice)
         status = true;  // Yes, the objects are equal.
      else
         status = false; // No, the objects are not equal.
      
      // Return the value in status.
      return status;
   }

   // copy method 
   public Stock copy()
   {
      // Create a new Stock object and initialize it
      // with the same data held by the calling object.
      Stock copyObject = new Stock(symbol, sharePrice);
      
      // Return a reference to the new object.
      return copyObject;
   }
   
   // Clone method
   public Stock clone()
   {
      return new Stock(this);    // implicit calling object
   }
}
