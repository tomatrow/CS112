/*
File Name:          Chapter13Project02.java
Programmer:         Andrew Caldwell
Date Last Modified: March. 21, 2014

Problem Statement:
Show understanding of the Comparable interface.

Overall Plan:
Implement comparable in InventoryItem
Use in main class

Classes needed and Purpose:
main class - Chapter13Project02
InventoryItem - Inventory model
*/


import java.util.Arrays;

public class Chapter13Project02 {
	public static void main(String[] args) {
		InventoryItem[] items = {new InventoryItem("PetCo",24), new InventoryItem("Costco", 4), new InventoryItem("Geeks",8)};
		System.out.println("Unsorted: " + Arrays.toString(items));	
		Arrays.sort(items, null);
		System.out.println("Sorted:   " + Arrays.toString(items));
	}
}