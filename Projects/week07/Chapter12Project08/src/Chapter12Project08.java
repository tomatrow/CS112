/*
File Name:          Chapter12Project08.java
Programmer:         Andrew Caldwell
Date Last Modified: March. 28, 2014

Problem Statement:
	* Optimise the book's QuickSort implementation. 

Overall Plan:
	* Use average for split value. 
	* Remove `join()`

Classes needed and Purpose:
main class - Chapter12Project08
QuickSort - sort double arrays 
*/

import java.util.Arrays;

public class Chapter12Project08 {
	public static void main(String[] args) {
		double[] unsorted = {9,8,7,6,5,4,3,2,1};
		System.out.println("Unsorted Array: \n" + Arrays.toString(unsorted));

		QuickSort.sort(unsorted);
		System.out.println("Sorted Array: \n" + Arrays.toString(unsorted));
	}
}