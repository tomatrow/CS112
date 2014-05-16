/*
File Name:          Handout03Project02.java
Programmer:         Andrew Caldwell
Date Last Modified: March. 28, 2014

Problem Statement:
	* Use recursion to identify palindromes from alpha only strings.

Overall Plan:
	input = same case alpha characters
	test input for palindrome idenity using recursion

Classes needed and Purpose:
main class - Handout03Project02
*/

public class Handout03Project02 {
	
	public static void main(String[] args) {
		String test = "Straw? No, too stupid a fad, I put soot on warts.";
		String onlySameCaseAlpha = getOnlyAlpha(test);
		boolean testIsPalindrome = isRecursivePalindrome(onlySameCaseAlpha);

		System.out.println(String.format("Test String: \n%s\nTest String is %sa Palindrome",test,(testIsPalindrome)?(""):("not ")));
	}
	

	public static boolean isRecursivePalindrome(String input) {
		if (input.length()<=1)
			return true;
		
		String matchA = input.substring(0,1);
		String matchB = input.substring(input.length()-1, input.length());

		return  matchA.equals(matchB) && isRecursivePalindrome(input.substring(1,input.length()-1));
	}


	public static String getOnlyAlpha(String input) { 
		String output = new String();
		
		for (int x = 0;x < input.length();x++) {
			String curentCharacter = input.substring(x,x+1);
			if (curentCharacter.matches("[A-Za-z]")) {
				output = output + curentCharacter;
			}
		}

		return output.toLowerCase();
	}

	// public static boolean isIterativePalindrome(String input) {
	// 	boolean isPalindrome = true;
		
	// 	if (input.length() <= 1)
	// 		return true;
	// 	for (int x = 0;x < input.length()/2;x++) {
	// 		String matchA = input.substring(x,x+1);
	// 		String matchB = input.substring(input.length()-x-1, input.length()-x);
	// 		if (!matchA.equals(matchB)) {
	// 			isPalindrome = false;
	// 		}
	// 	}

	// 	return isPalindrome;
	// }

}