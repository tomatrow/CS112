/*
File Name:          Chapter10Project01.java
Programmer:         Andrew Caldwell
Date Last Modified: Feb. 28, 2014

Problem Statement:
Read two text files and let the user query them. 

Overall Plan:
read file 
prompt user 
display data


Classes needed and Purpose:
main class - Chapter10Project01
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

public class Chapter10Project01 {
	public static final File BOY_INPUT_FILE = new File(System.getenv("PWD") + "/bld/" + "boynames.txt");
	public static final File GIRL_INPUT_FILE = new File(System.getenv("PWD") + "/bld/" + "girlnames.txt");
	
	public static void main(String[] args) {
		NameContainer[] boys = getNameContainers(true);
		NameContainer[] girls = getNameContainers(false);
		NameContainer[] all = concat(boys,girls);
		
		String inputName = getInputName();
		int[] indexes = indexesOfName(all, inputName);
		
		String arrayString = nameContainerArrayString(nameContainersForIndexes(all,indexes));
		System.out.println(arrayString);
	}

	public static String getInputName() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("What is the name you world like to know about?");
		String input = keyboard.nextLine();
		keyboard.close();
		return input;
	}
	
	public static NameContainer[] getNameContainers(boolean gender) {
		Scanner input;
		NameContainer[] containers = new NameContainer[0];
		try {
			File inputFile = (gender)?BOY_INPUT_FILE:GIRL_INPUT_FILE;
			input = new Scanner(inputFile);
			int rank = 1;
			while (input.hasNextLine()) {
				// read one object 
				String[] data = input.nextLine().split(" ");
				containers = append(containers,new NameContainer(data[0],rank,gender,Integer.valueOf(data[1])));
				rank++;
			}
			input.close();
		} 
		catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
		return containers;
	}
	

	public static NameContainer[] append(NameContainer[] array, NameContainer object) {
		NameContainer[] result = Arrays.copyOf(array,array.length+1);
		result[result.length-1] = object;
		return result;
	}
	public static NameContainer[] concat(NameContainer[] first, NameContainer[] second) {
	  NameContainer[] result = Arrays.copyOf(first, first.length + second.length);
	  System.arraycopy(second, 0, result, first.length, second.length);
	  return result;
	}
	public static int[] indexesOfName(NameContainer[] array, String name) {
		int[] indexes = new int[0];
		for (int x = 0;x < array.length;x++) {
			if (array[x].getName().equals(name)) {
				indexes = Arrays.copyOf(indexes,indexes.length+1);
				indexes[indexes.length-1] = x;
			}
		}
		return indexes;
	}
	public static String nameContainerArrayString(NameContainer[] containers) {
		String output = "";
		for (NameContainer n : containers) {
			output = output.concat(nameContainerFormatString(n) + "\n");
		}
		return output;
	}
	public static String nameContainerFormatString(NameContainer container) {
		return String.format("%s is ranked %d in popularity among %ss with %d namings.",container.getName(),container.getRank(),((container.getGender())?"boy":"girl"), container.getCount());
	}
	public static NameContainer[] nameContainersForIndexes(NameContainer[] containers, int[] indexes) {
		NameContainer[] output = new NameContainer[0];
		for (int x : indexes) {
				output = append(output,containers[x]);
		}
		return output;
	}
}