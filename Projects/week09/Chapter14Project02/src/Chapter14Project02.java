/*
File Name:          Chapter14Project02.java
Programmer:         Andrew Caldwell
Date Last Modified: April. 04, 2014
Problem Statement:
	Discover how easy useing ArrayList can be. 

Overall Plan:
	Write contact model
	Write contact's model
	Write interface 
		Write user to string by pattern matching method. 
			Derive all other user input form that method. 
		Use switch statement in loop
			each choice edits/querys the model

Classes needed and Purpose:
main class - Chapter14Project02
ContactDatabase - group contacts 
Contact - single contact model 
*/

import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.List;

public class Chapter14Project02 {
	public static String MENU_STRING = "Main Menu:\n1. Add\n2. Display All\n3. Display Search\n4. Delete\n5. Exit";
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		Contact alice = new Contact("Alice", "inWonderland", "alice@wonderland.org");
		Contact frodo = new Contact("Frodo","Baggins", "frodo@mordor.io");
		Contact vin = new Contact("Vin","Sanderson", "vin@gmail.com");
		List testContacts = Arrays.asList(alice, vin, frodo);

		ContactDatabase database = new ContactDatabase(testContacts);

		boolean runLoop = true;

		do {
			System.out.println(MENU_STRING);
			switch (getUserMainMenuChoice()) {
				case 1: add(database);
						break;
				case 2: displayAll(database);
						break;
				case 3: displaySearch(database);
						break;
				case 4: delete(database);
						break;
				case 5: runLoop = false;
						break; 
			} 
		} while (runLoop);
		
		keyboard.close();	
	}
	
	// Menu Commands 
	public static void add(ContactDatabase database) {
		database.add(getUserContact());
	}
	public static void displayAll(ContactDatabase database) {
		String[] lines = database.toString().split(" ");
		for (String line : lines) {
			System.out.println(line);
		}
	}
	public static void displaySearch(ContactDatabase database) {
		String userSearchTerm = getUserString("Search Term for Display");
		ArrayList<Contact> contact = getSingleContact(database.matches(userSearchTerm));
		if (contact.size() == 1)
			System.out.println(contact.get(0));
	}
	public static void delete(ContactDatabase database) {
		String userSearchTerm = getUserString("Search Term for Deletion");
		ArrayList<Contact> contact = getSingleContact(database.matches(userSearchTerm));

		if (contact.size() == 1) {
			System.out.println("Delete: "+ contact.get(0) + "?");
			if (getUserChoice()) {
				database.remove(contact.get(0));
			}
		}
	}

	// User interaction 
	public static ArrayList<Contact> getSingleContact(ArrayList<Contact> contacts) { 
		if (contacts.size() <= 1)
			return contacts;

		while(contacts.size() > 1) {
			String userSearchTerm = getUserString("Search Term").toLowerCase();
			/*
				The array can't be edited while being iterated. 

				Two things are hard for CS Majors.
				Valiable names and concurrency. 
			*/
			ArrayList<Contact>contactsToRemove = new ArrayList<Contact>();
			for (Contact c : contacts) {
				if (c.searchString().indexOf(userSearchTerm) == -1) {
					contactsToRemove.add(c);
				}
			}
			for (Contact c : contactsToRemove) {
				contacts.remove(c);
			}

			System.out.println("Search returns " + contacts.toString());
		}


		return contacts;
	}
	public static boolean getUserChoice() {
		String userChoice = getUserString("Choice(y/n)","y|n|yes|no");
		if (userChoice.matches("y|yes")) {
			return true;
		} else  {
			return false;
		}
	}
	public static int getUserMainMenuChoice() {
		return Integer.valueOf(getUserString("Menu Choice", "[12345]"));
	}
	public static Contact getUserContact() {
		Contact userContact = new Contact();

		System.out.println("Enter a Contact: ");

		userContact.setFirstName(getUserString("First Name"));
		userContact.setLastName(getUserString("Last Name"));
		userContact.setMailAddress(getUserString("E-Mail Address",Contact.MAIL_REGEX));

		return userContact;
	}
	public static String getUserString(String dataName, String regex) {
		Scanner keyboard = new Scanner(System.in);
		keyboard.useDelimiter("\n");

		System.out.println("Enter a " + dataName);
		while(!keyboard.hasNext(Pattern.compile(regex))) {
			System.out.println("Improper " + dataName);
			keyboard.nextLine();
		}

		return keyboard.next();
	}
	public static String getUserString(String dataName) {
		return getUserString(dataName, ".*");
	}

}