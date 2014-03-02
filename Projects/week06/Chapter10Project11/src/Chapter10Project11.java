/*
File Name:          Chapter10Project11.java
Programmer:         Andrew Caldwell
Date Last Modified: Feb. 28, 2014

Problem Statement:
Make an entire program around a Person[];

Overall Plan:
Use person and date in the manager
use them in main

Classes needed and Purpose:
main class - Chapter10Project11
Person - holding Person data
Date - holding data data
PetRecordManager - Info and storage for an array of person records


- - - - - - - - 

# Personal Plan
Key
        '@' == class
        '*' == property
        '+' == class method
        '-' == instance method
        '#' == comment
        '[' == start message
        ']' == end message

roadmap start 
	make Person and Date serializable
	create a manager 
	create a formatter 
roadmap end

flowplan start
flowplan end

classplan start 
	@PersonManager

classplan end 

*/

import java.util.Arrays;
import java.util.Scanner;

public class Chapter10Project11 {
	public static final Person[] testPersons = {new Person("j",new Date(1955),new Date(1967))};
	public static final String MENU_STRING = "1. Print Records\n2. Add Record\n3. Remove Record\n4. Records in age Range \n5. Quit\n";
	public static final String[] VALID_CHOICES = {"y","n"};
	public static void main(String[] args) {
		PersonManager manager = new PersonManager();
		manager.unarchive();
		// System.out.println(Arrays.toString(manager.getPersons()));
		Date currentDate = getCurrentDate(); // done 
		int menuChoice = getMenuChoice();   // done 
		switch (menuChoice) {
			case 1:
				System.out.println(personsPrint(manager.getPersons()));
				break;
			case 2:
				manager.add(getUserPerson(currentDate));
				break;
			case 3:
				manager.remove(manager.search(getValidname(manager.getPersons())));
				break;
			case 4: 
				int[] ageRange = getValidAgeRange();
				System.out.println(personsPrint(manager.withAgeRange(ageRange[0],ageRange[1],currentDate)));
				break;
			case 5:
				break;
		}

		manager.archive();		
	}
	
	public static String getValidname(Person[] persons) {
		Scanner keyboard = new Scanner(System.in);
		String name;
		System.out.println("What is the name?");
		do {
			name = keyboard.nextLine();
			if (!PersonManager.contains(PersonManager.getPersonNames(persons),name)) {
				System.out.println("That person is not in the database.");
			}
		} while (!PersonManager.contains(PersonManager.getPersonNames(persons),name));

		// keyboard.close();
		return name;
	}

	public static int[] getValidAgeRange() {
		int[] validRange = {-1,-1};
		Scanner keyboard = new Scanner(System.in);
		do {
			for (int x = 0;x < validRange.length;x++) {
				System.out.println("Enter the " + ((x == 0)?"lower":"upper") + " limit.");
				while (!keyboard.hasNextInt()) {
					System.out.println("Need an integer");
					keyboard.next();
				}
				validRange[x] = keyboard.nextInt();
			}
			if (validRange[0] > validRange[1]) {
				System.out.println("The ages are inconsistent.");
			}
		} while (validRange[0] > validRange[1]); //invalid

		// keyboard.close();
		return validRange;
	}
	public static Person getUserPerson(Date currentDate) {
		Scanner keyboard = new Scanner(System.in);
		keyboard.reset();
		String name = "";
		Date birth = new Date();
		Date death = new Date();
		Date futureDeath = new Date(currentDate.getYear() + 1);
		System.out.println("What is their name?");
		
		name = keyboard.next();
		
		do {
			System.out.println("What is their birthdate?");
			birth.readInput();
			if (getFlowChoice("Is the person alive?")) {
				death = futureDeath;
			} else {
				System.out.println("What is their deathdate?");
				death.readInput();
			}

			if (!birth.precedes(death)) {
				System.out.println("Birth must precede death.");
			}
		} while (!birth.precedes(death));

		// keyboard.close();
		return new Person(name,birth,death);
	}

	public static int getMenuChoice() {
		Scanner keyboard = new Scanner(System.in);
		int choice = -1;
		System.out.println(MENU_STRING);
		do {
			while (!keyboard.hasNextInt()) {
				System.out.println("Enter a integer.");
				keyboard.next();
			}
			choice = keyboard.nextInt();
			if (choice < 1 || choice > 5) {
				System.out.println("Enter a integer between 1 and 5.");
			}
		} while (choice < 1 || choice > 5);

		// keyboard.close();
		return choice;
	}

	public static Date getCurrentDate() {
		System.out.println("What is today's date?");
		Date currentDate = new Date();
		currentDate.readInput();
		return currentDate;
	}

	public static String personsPrint(Person[] persons) {
		String arrayString = Arrays.toString(persons);
		String[] lines = arrayString.substring(0,arrayString.length() - 1).split(",");
		String header = "Index - Name - Birth - Death\n";
		String output = "";

		output = output.concat(header);
		for (int x = 0;x < lines.length;x++) {
			output = output.concat(x + lines[x].substring(1) + "\n");
		}
		return output;
	}
	public static boolean getFlowChoice(String question) {
		Scanner keyboard = new Scanner(System.in);
		String choice;
		System.out.println(question);
		do {
			choice = keyboard.nextLine();
			if (!PersonManager.contains(VALID_CHOICES, choice.toLowerCase())) {
				System.out.println("You need to enter y or n");
			}
		} while (!PersonManager.contains(VALID_CHOICES, choice.toLowerCase()));
		return (choice.toLowerCase().equals("y"))?true:false;
	}
}