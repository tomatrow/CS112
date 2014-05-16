// This program displays a simple window with a title. The application
// exits (closes) when the user clicks the close button.

import javax.swing.*;     // Needed for Swing classes

public class CreateWindow
{
	public static void main(String[] args)
	{
		final int WINDOW_WIDTH = 350;    // Window width in pixels
		final int WINDOW_HEIGHT = 250;   // Window height in pixels
		
		// Create a window with a title - will initially be invisible.
		JFrame window = new JFrame("My First Window");
		
		// Set the size of the window using a JFrame method
		window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		
		// Specify what happens when the close button is clicked
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Make the window visible on the screen
		window.setVisible(true);
	}
}