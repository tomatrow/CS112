import javax.swing.JFrame;

/*
	File Name:          Chapter17Project01.java
	Programmer:         Andrew Caldwell
	Date Last Modified: May. 2, 2014
	Problem Statement:
		Create a GUI application for translating text into pig latin. 
		
	Overall Plan:
		Pig Latin Converter
			Match words that begin with vowels using regexes
				if true: Use vowels procedure
				else: consonant procedure
		Main Window 
			JFrame
				JTextArea: raw text 
				JTextArea: translated pig latin
				JButton: translate action

	Classes needed and Purpose:
	main class - Chapter17Project01
	MainFrame - The main view we build upon 
	PigLatinConverter - taks text and returns pig latin 
*/



public class Chapter17Project01 {
	public static void main(String[] args) {
		JFrame mainFrame = new MainFrame();
	}
}