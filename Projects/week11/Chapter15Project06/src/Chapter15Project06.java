/*
File Name:          Chapter15Project06.java
Programmer:         Andrew Caldwell
Date Last Modified: April. 18, 2014
Problem Statement:
	Implement a sorted insertion for a generic linked list. 

Overall Plan:
	Implement addSort() for a single item, then two items, and see a pattern. 
	Implement pattern. 
	Use java's collections instead of arrays. Arrays are _so_ three weeks ago. 

Classes needed and Purpose:
main class - Chapter15Project06
LinkedList3 - the linked list
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class Chapter15Project06 {
	public static void main(String[] args) {
		LinkedList3 <Integer> linkedList = new LinkedList3<Integer>();
		List <Integer> arrayList = new ArrayList<Integer>(10);
		
		for (int x = 0;x < 10;x++)
			arrayList.add(x);
		Collections.shuffle(arrayList);
		
		for (Integer i : arrayList)
			linkedList.addSorted(i);

		System.out.println("Raw data:    " + arrayList);
		System.out.println("Data in sorted linked list: " + linkedList);
	}
}