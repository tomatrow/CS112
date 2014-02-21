//This class demonstrates the use of the Exception class

import java.util.*;

public class MyExceptionDemo
{
	public static void main(String[] args)
	{
		MyExceptionDemo demo = new MyExceptionDemo();
	
		try
		{
		System.out.println("Trying");
		demo.newMethod();
		System.out.println("Trying after call.");
		}
		
		catch(Exception e)
		{
		System.out.println("Catching");
		System.out.println(e.getMessage());
		}
	}
	
	public void newMethod() throws Exception
	{
		System.out.println("Starting newMethod.");
		throw new
		     Exception("Throwing an Exception from newMethod .");
	}
}