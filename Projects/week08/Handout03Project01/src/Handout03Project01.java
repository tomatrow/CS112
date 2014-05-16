/*
File Name:          Handout03Project01.java
Programmer:         Andrew Caldwell
Date Last Modified: March. 28, 2014

Problem Statement:
	* Make a program that accepts integers and spits out factorials. 

Overall Plan:
	* Get integers input and give the user factorials while they still want them. 
		do 
			get integer
			print factorial from integer
		while (userWantsFactorials?)

Classes needed and Purpose:
main class - Handout03Project01
*/


import java.util.Scanner;

public class Handout03Project01 {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		do {
			System.out.println(factorial(getUserInteger()));
		} while(getUserChoice());

		keyboard.close();
	}

	public static boolean getUserChoice() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Run again?");

		while (!keyboard.hasNext("yes|no")) {
			System.out.println("Enter \"yes\" or \"no\" ");
			keyboard.nextLine();
		}
		boolean userChoice = keyboard.next().equals("yes");
		// keyboard.close(); /* Closing input before exit throws exceptions*/
		return userChoice;
	}

	public static int getUserInteger() {
		int userInteger;
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter an integer for the factorial function.");
		
		while (!keyboard.hasNextInt()) {
			System.out.println("Enter an integer.");
			keyboard.next();
		}

		userInteger = keyboard.nextInt();
		// keyboard.close(); /* Closing input before exit throws exceptions*/
		return userInteger;
	}

	public static int factorial(int n) {
		return (n <= 1)?(1):(n*factorial(n-1));
	}
}