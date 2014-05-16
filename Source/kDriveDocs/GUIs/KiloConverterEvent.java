// The KiloConverterEvent class lets the user enter a distance
// in kilometers. When the Calculate button is clicked, a dialog 
// box is displayed with the distance converted to miles.

import javax.swing.*;
import java.awt.event.*;      //needed for event listener

public class KiloConverterEvent extends JFrame

{
	private JPanel panel;                 // A panel container
	private JLabel messageLabel;          // A message to display
	private JTextField kiloText;          // To hold user input
	private JButton calcButton;           // Performs calculation
	private final int WINDOW_WIDTH = 320;
	private final int WINDOW_HEIGHT = 100;
	
	// Constructor
	public KiloConverterEvent()
	{
		// Call the JFrame Constructor
		super("Kilometer Converter");
		
		// Set the size of the window using a JFrame method
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		
		// Specify what happens when the close button is clicked
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Build the panel and add it to the frame
		buildPanel();
		
		// Add the panel to the frame's content pane
		add(panel);
		
		// Make the window visible on the screen
		setVisible(true);
	}
	
	// The buildPanel method adds a label, text field, and a 
	// button to a panel.
	private void buildPanel()
	{
		// Create the label, text field, and button components
		messageLabel = new JLabel("Enter a distance in kilometers");
		kiloText = new JTextField(10);  // Size of field
		calcButton = new JButton("Calculate");
		
		// Add an action listener to the button
		calcButton.addActionListener(new CalcButtonListener());
		
		// Create a panel to hold the components
		panel = new JPanel();
		
		// Add the label, text field, and button to the panel
		panel.add(messageLabel);
		panel.add(kiloText);
		panel.add(calcButton);
	}
	
	// Private inner class that handles the event when the user clicks
	// on the calculate button
	private class CalcButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String str;               // To hold text entered
			double miles;             // To hold miles
			
			// Get number of kilometers from the user. Input entered 
			// in the text field is a string.
			str = kiloText.getText();
			
			// Convert the kilometers to miles
			miles = Double.parseDouble(str) * 0.6214;
			
			// Display a message dialog showing the miles
			JOptionPane.showMessageDialog(null, str + 
			            " kilometers is " + miles + " miles.");
		}
	 } 
}