//This class demonstrates the MagicException class

import java.util.*;

public class MagicExceptionTest
{
	public static void main(String[] args)
	{
		MagicException magic = new MagicException();
		System.out.println(magic.getMessage());
		magic.magicMethod();
	}
}