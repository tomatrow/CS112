/*
File Name:          Chapter14Project04.java
Programmer:         Andrew Caldwell
Date Last Modified: April. 04, 2014
Problem Statement:
	Implement a Standard Deviation method using Generics.

Overall Plan:
	Translate Wikipedia example into Java. 
	Test in main. 


Classes needed and Purpose:
main class - Chapter14Project04
MyMathClass - Standard Deviation with Generics.
*/


import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class Chapter14Project04 {
	public static void main(String[] args) {
		MyMathClass math = new MyMathClass();
		Double[] doubles = {2.0,4.0,4.0,4.0,5.0,5.0,7.0,9.0};
		ArrayList<Double> testvalues = new ArrayList<Double>(Arrays.asList(doubles));

		double stdDev = math.standardDeviation(testvalues);

		System.out.println(String.format("The Standard Deviation of:\n%s\nis:\n%s",testvalues,stdDev));
	}
}