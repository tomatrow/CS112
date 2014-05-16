// This class inherits from the JFrame class. Its constructor
// displays a simple window with a title. The application
// exits (closes) when the user clicks the close button.

import javax.swing.*;
import java.awt.*;     // Needed for Swing classes

public class CreateWindow3 extends JFrame
{
	public CreateWindow3()
	{
		// Call the JFrame Constructor and pass the title
		super("My Third Colored Window");
		
		final int WINDOW_WIDTH = 350;    // Window width in pixels
		final int WINDOW_HEIGHT = 250;   // Window height in pixels
		
		// Set the size of the window using a JFrame method
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		
		// Specify what happens when the close button is clicked
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		getContentPane().setBackground(Color.PINK);
		
		// Make the window visible on the screen
		setVisible(true);
	}
}