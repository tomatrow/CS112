// DateStringTokenTester.java
// This program demonstrates the DateStringToken class using
// the StringTokenizer class.

public class DateStringTokenTester
{
	public static void main(String[] args)	
	{
		String date = "2/12/2014";
		
		//Create DateStringToken object
		DateStringToken dateItems = 
		    new DateStringToken(date);
		    
		System.out.println("Here's the date: " + date);
		System.out.println("The month is: " + dateItems.getMonth());
		System.out.println("The day is: " + dateItems.getDay());
		System.out.println("The year is: " + dateItems.getYear());
	}
}