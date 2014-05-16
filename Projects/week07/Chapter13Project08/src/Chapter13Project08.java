/**
File Name:          Chapter13Project08.java
Programmer:         Andrew Caldwell
Date Last Modified: March. 21, 2014

Problem Statement:
Show understanding of Interfaces and inner classes.

Overall Plan:
Implement comparable in Date 
Implement comparable in Person
Use arrays in a Person constructor
Show off in main class

Classes needed and Purpose:
main class - Chapter13Project08
Person - person model
Date - date model 
*/


public class Chapter13Project08 {
	public static void main(String[] args) {
		int[] birthParam = {1,1,1000};
		int[] deathParam = {2,2,2000};

		Person p = new Person("Bob", birthParam,deathParam);
		Person pClone = (Person)p.clone();
		boolean areEqual = p.equals(pClone);

		System.out.println("Person: " + p);
		System.out.println("Clone: " + pClone);
		System.out.println("The person and its clone are " + (areEqual?"":"not ") + "equal.");
	}
}