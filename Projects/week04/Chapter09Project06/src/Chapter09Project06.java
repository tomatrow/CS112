/* Chapter 09 - Project No. 02
    File Name:          Chapter09Project06.java
    Programmer:         Andrew Caldwell
    Date Last Modified: Feb. 21, 2014

    Problem Statement:
	Use argument exceptions in a calculator program. 

    Overall Plan
	start
		core loop
			calculation loop 
				operation
				end
			end
		end
	end

    Classes needed and Purpose
    main class - Chapter09Project06
	Calculator - Perfroms operations on its data
	Operation - Embodies an operation
	UnknownOperatorException - signifies illegal operator 
*/

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.Scanner;

public class Chapter09Project06 {
	public static final String[] CMDS = {"r","R"};
	public static void main(String[] args) {
		Scanner _keyboard = new Scanner(System.in);
		Calculator _calc = new Calculator();

		System.out.println("Calculator is on.");

		runLoop(_keyboard,_calc);

		System.out.println("End of Program");

		_keyboard.close();
	}
	public static void runLoop(Scanner keyboard, Calculator calculator) {
		while (true) {
			String input = new String();
			String operator = new String();
			double operand = 1.0;
			String[] validInput = concatenate(Operation.VALID_OPERATORS,CMDS);
			boolean isValidInput = false;
			if (operator.toLowerCase().equals("r"))
				break;

			while (!input.toLowerCase().equals("r")) {
				do {
					System.out.println("result = " + calculator.getResult());
					input = keyboard.nextLine();
					// System.out.println("Operators:" + Arrays.toString(Operation.VALID_OPERATORS) + " Commands:" + Arrays.toString(CMDS) + " Format: [operator/command][operand]");
					if (input.length() > 0) {
						operator = input.substring(0,1);
						isValidInput = Arrays.asList(validInput).contains(operator);
						if (!isValidInput) 
							System.out.println(input.substring(0,1) + " is an unknown operation or command.");
						else if (operator.toLowerCase().equals("r"))
							break;
					}
					try {
						operand = Double.valueOf(input.substring(1)).doubleValue();
	 				} catch (NumberFormatException e) {
						System.out.println("Operand must be a number.");
						input = "";
					}
				} while (input.length() < 2 || !isValidInput);
				if (operator.toLowerCase().equals("r"))
					break;

				if (operator.equals("+"))
					calculator.add(operand);
				else if (operator.equals("-"))
					calculator.subtract(operand);
				else if (operator.equals("*")) 
					calculator.multiply(operand);
				else if (operator.equals("/"))
					calculator.divide(operand);
				else 
					throw new UnknownOperatorException(operator + " is not valid.");

				System.out.println("result " + operator + " " + operand + " = " + calculator.getResult());
			}


			String choice;
			boolean validChoice;

			do {
				System.out.println("Again?(y/n)");
				choice = keyboard.nextLine();
				validChoice = choice.matches("[yYnN]");
			} while(!validChoice);
			
			if (choice.toLowerCase().equals("n"))
				break;
			else 
				calculator.clear();
		}
	}


	public static  String[] concatenate(String[] stringA, String[] stringB) {
		int aLength = stringA.length;
		int bLength = stringB.length;

		String[] stringC = new String[aLength+bLength];

		System.arraycopy(stringA, 0, stringC, 0, aLength);
		System.arraycopy(stringB, 0, stringC, aLength, bLength);

		return stringC;
	}
}