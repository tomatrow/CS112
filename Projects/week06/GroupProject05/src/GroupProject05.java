import java.util.Scanner;
import java.util.Arrays;
public class GroupProject05 {
	public static void main(String[] args) {

		String entireFileInput = "123,234\n456,234\n789,432\n";		
		String[] lineSeperatedInput = entireFileInput.split("\n");
		// System.out.println(Arrays.toString(lineSeperatedInput));
		for (int x = 0;x < lineSeperatedInput.length;x++) {
			
		}

		// int[][] intValues = new int[lineSeperatedInput.length][];


		// for (int i = 0;i < lineSeperatedInput.length;i++) {				// Each line 
		// 	intValues[i] = new int[lineSeperatedInput[i].length()];   	// word holder 
		// 	for (int x = 0;x < lineSeperatedInput[i].length();i++) { 	// each word
		// 		intValues[i][x] = (int)lineSeperatedInput[i].charAt(x); // each char
		// 	}
		// }		
		// int integer = 11;
		// int reversed = Integer.reverse(integer);	
		// integer = Integer.reverse(reversed);
		// System.out.println(integer + " reversed is " + reversed);



	}

	public static  int[] concatenate(int[] intsA, int[] intsB) {
		int aLength = intsA.length;
		int bLength = intsB.length;

		int[] intsC = new int[aLength+bLength];

		System.arraycopy(intsA, 0, intsC, 0, aLength);
		System.arraycopy(intsB, 0, intsC, aLength, bLength);

		return intsC;
	}
}