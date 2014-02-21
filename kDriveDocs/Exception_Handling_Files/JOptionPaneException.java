//This class demonstrates how to catch and handle number format and 
//division by zero exceptions in programs that use input dialog boxes
//and/or text fields.

import javax.swing.JOptionPane;

public class JOptionPaneException
{
	public static void main(String[] args)
	{
		int dividend, divisor, quotient;
		String inpStr;
		
		try
		{
			inpStr =
			     JOptionPane.showInputDialog("Enter the dividend: ");
			dividend = Integer.parseInt(inpStr);
			
			inpStr =
			     JOptionPane.showInputDialog("Enter the divisor: ");
			divisor = Integer.parseInt(inpStr);
			
			quotient = dividend/ divisor;
			
			JOptionPane.showMessageDialog(null,
			     "\nDividend = " + dividend
			     + "\nDivisor= " + divisor
			     + "\nQuotient = " + quotient,
			     "Quotient",JOptionPane.INFORMATION_MESSAGE);
	     }
			     
		 catch (ArithmeticException aeRef)
		 {
			JOptionPane.showMessageDialog(null,
				 "Exception "
				 + aeRef.toString(),
				 "ArithmeticException",
				 JOptionPane.ERROR_MESSAGE);
		 }
		 
		 catch (NumberFormatException nfeRef)
		 {
			JOptionPane.showMessageDialog(null,
				 "Exception "
				 + nfeRef.toString(),
				 "NumberFormatException",
				 JOptionPane.ERROR_MESSAGE);
		 }
		 
		 System.exit(0);
	}
}