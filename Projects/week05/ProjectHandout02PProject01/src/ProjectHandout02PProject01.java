/*
File Name:          ProjectHandout02PProject01.java
Programmer:         Andrew Caldwell
Date Last Modified: Feb. 28, 2014

Problem Statement:
Read text from a file into another, and remve the duplicates. 

Overall Plan:
read file 
remove duplicates
write file 

Classes needed and Purpose:
main class - ProjectHandout02PProject01

*/

import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.PrintStream;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ProjectHandout02PProject01 {
	public static final File INPUT_FILE = new File(System.getenv("PWD") + "/bld/" + "input.txt");
	public static final File OUTPUT_FILE = new File(System.getenv("PWD") + "/bld/" + "output.txt");

	public static void main(String[] args) {
		fileOutput(removeDuplicates(fileInput(getFile("Input"))),getFile("Output"));
	}
	public static File getFile(String type) {
		Scanner keyboard = new Scanner(System.in);
		String fileName = "";
		File file = null;
		boolean done = false; 
		while (!done) {
			System.out.println("What is the " + type + " file name?");
			fileName = keyboard.nextLine();
			file = new File(fileName);
			if (!file.exists()) {
				System.out.println("File does not exist.");
			}
			done = true;
		}
		return file;
	}

	public static int[] removeDuplicates(int[] intArray) {
		int[] noDuplicates = {intArray[0]};

		for (int x = 0, y = 0;x < intArray.length;x++) {
			if (noDuplicates[y]!= intArray[x]) {
				noDuplicates = appendInt(noDuplicates,intArray[x]);
				y++;
			}
		}

		return noDuplicates;
	}
	public static int[] fileInput(File inputFile) {
		Scanner input;
		int[] inputInts = new int[0];
		try {
			input = new Scanner(inputFile);
			while (input.hasNextInt()) {
				inputInts = Arrays.copyOf(inputInts,inputInts.length+1);
				inputInts[inputInts.length-1] = input.nextInt();
			}
			input.close();
		} 
		catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
		return inputInts;
	}
	public static void fileOutput(int[] intArray,File outputFile) {
		PrintStream outputStream;
		try {
			if (!outputFile.exists())  {
				outputFile.createNewFile();
			}
			outputStream = new PrintStream(outputFile);
			for (int x = 0;x < intArray.length;x++) {
				outputStream.println(intArray[x]);
			}
		}
		catch (IOException e) {
			e.printStackTrace();
			System.exit(0);			
		}
		// catch (FileNotFoundException e) {
		// 	e.printStackTrace();
		// 	System.exit(0);
		// }
	}

	public static <T> T[] concat(T[] first, T[] second) {
	  T[] result = Arrays.copyOf(first, first.length + second.length);
	  System.arraycopy(second, 0, result, first.length, second.length);
	  return result;
	}
	public static <T> T[] append(T[] array, T object) {
		T[] result = Arrays.copyOf(array,array.length+1);
		result[result.length-1] = object;
		return result;
	}
	public static <T> boolean contains(T[] array, T object) {
		boolean result = false;
		for (T o : array) {
			if (o.equals(object))
				result = true;
		}
		return result;
	}
	public static <T> int[] indexesOfObject(T[] array, T object) {
		int[] indexes = new int[0];
		for (int x = 0;x < array.length;x++) {
			if (array[x].equals(object)) {
				indexes = Arrays.copyOf(indexes,indexes.length+1);
				indexes[indexes.length-1] = x;
			}
		}
		return indexes;
	}
	public static int[] appendInt(int[] intArray, int integer) {
		int[] result = Arrays.copyOf(intArray,intArray.length+1);
		result[result.length-1] = integer;
		return result;
	}
}