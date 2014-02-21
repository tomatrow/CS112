import java.util.Arrays;
import java.util.Scanner;
public class GroupProject04 {
		String[] validCoinNames = {"penny","nickle","dime","quarter"};

	public static void main(String[] args) {

		String userString;
		
		int[] validCoinValues = {1,5,10,25};
		
		int[] purse = new int[4];
		Scanner keyboard = new Scanner(System.in);

		for (int y = 0;y < 5;y++) {
			System.out.println("Enter a coin name");
			userString = keyboard.nextLine();
			int index = Arrays.binarySearch(validCoinNames,userString);
			if (index < 0 || index > purse.length) {
				// throw exception
			}
			else  {
				System.out.println(Arrays.binarySearch(validCoinNames,userString));
				purse[Arrays.binarySearch(validCoinNames,userString)]++;
			}
		}
		System.out.println(Arrays.toString(purse));
		System.out.println(purseValue(purse));
	}
	static int purseValue(int[] purse) {
		int[] validCoinValues = {1,5,10,25};
		int totalValue = 0;

		for (int x = 0; x < purse.length;x++) {
			totalValue += purse[x] * validCoinValues[x];
		}

		return totalValue;
	}
	static int indexForName(String name) {

	}
}