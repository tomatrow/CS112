public class MysteryValuesDemystified 
{
    static public void main(String[] args)
    {
    	System.out.println(mysteryValue(10));
    }
    
    public static int mysteryValue(int n)
    {
    	if (n <= 1)
    	{
    		System.out.println("base case, n = " + n);
    		return 1;
    	}
    	else
    	{
    		System.out.println("recursive case, n = " + n);
    		int x = mysteryValue(n - 1) + n;
    		System.out.println("returning " + x);
    		return (x);
    	}
    }
}