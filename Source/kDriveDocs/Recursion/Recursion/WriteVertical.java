public class WriteVertical
{
	public static void main(String [] args)
	{
		System.out.println("WriteVertical(3):");
		writeVertical(3);
		
		System.out.println("WriteVertical(12):");
		writeVertical(12);
		
		System.out.println("WriteVertical(123):");
		writeVertical(123);				
	}

    public static void writeVertical(int n)
    {
	    if (n < 10)
	    {
	        System.out.println(n);		
	    }
	
	    else   // n is two or more digits
	    {
		    writeVertical(n/10);
		    System.out.println(n % 10);
	    }
	}
}