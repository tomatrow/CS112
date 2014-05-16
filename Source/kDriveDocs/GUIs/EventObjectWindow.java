// This class demonstrates how to retrieve the action command
// from an event object.

import javax.swing.*;
import java.awt.event.*;

public class EventObjectWindow extends JFrame
{
	private JPanel panel;                 // A panel container
	private JButton button1;              // Button 1
	private JButton button2;              // Button 2
	private JButton button3;              // Button 3
	private final int WINDOW_WIDTH = 320;
	private final int WINDOW_HEIGHT = 70;
	
	// Constructor
	public EventObjectWindow()
	{
		// Call the JFrame Constructor and set title bar text
		super("Event Object Demonstration");
		
		// Set the size of the window using a JFrame method
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		
		// Specify what happens when the close button is clicked
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Create the three buttons
		button1 = new JButton("Button 1");
		button2 = new JButton("Button 2");
		button3 = new JButton("Button 3");
		
		// Register an event listener with all 3 buttons
		button1.addActionListener(new ButtonListener());
		button2.addActionListener(new ButtonListener());
		button3.addActionListener(new ButtonListener());
		
		// Create a panel and add the buttons to it
		panel = new JPanel();
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		
		// Add the panel to the frame's content pane
		add(panel);
		
		// Make the window visible on the screen
		setVisible(true);
	}

	// Private inner class that handles the event when the user clicks
	// on a button
	private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			JOptionPane.showMessageDialog(null, 
			           "The action command for this event is " +
			           e.getActionCommand());
			
			System.out.println( 
			           "You clicked " + e.getSource() + "button.");
			if (e.getSource() == button3)
			{
				System.out.println("You clicked " + "the third button.");
			}
		         
		}
	}
}