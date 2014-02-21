// DateStringToken.java
// This class extracts the month, day and year from a String
// containing a date. It uses the StringTokenizer class.

import java.util.StringTokenizer;

public class DateStringToken
{
	private String month;
	private String day;
	private String year;
	
	//The constructor accepts a String (dateStr)containing a date
	//in the form MONTH/DAY/YEAR. It extracts the month, day,
	//and year from the string.
	public DateStringToken(String dateStr)
	{
		//Create a StringTokenizer object
		StringTokenizer strToken = 
		    new StringTokenizer(dateStr, "/");
		
		//Extract the tokens
		month = strToken.nextToken();
		day   = strToken.nextToken();
		year  = strToken.nextToken();		
	}
	
	public String getMonth()
	{
		return month;
	}
	
	public String getDay()
	{
		return day;
	}
	
	public String getYear()
	{
		return year;
	}
}