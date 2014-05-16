/*
	File Name:          ProjectHandout04Project01.java
	Programmer:         Andrew Caldwell
	Date Last Modified: May. 9, 2014
	Problem Statement:
		Create a program that showcases several different border styles. 

	Overall Plan:
		* Create a menu bar with multi layered popup menus 
			* Pack the button information into a command string 
		* Have a listener unpack the command string and change the border around the main panel accordingly 

	Classes needed and Purpose:
	main class - ProjectHandout04Project01
	MenuBar - allows selection of different borders 
	MainPanel - contains a label with a border
	BorderActionListener - handles button events 

*/

public class ProjectHandout04Project01 {
	public static void main(String[] args) {
		MainPanel panel = new MainPanel();
	}
}