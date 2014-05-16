// The KiloConverterWindow class demonstrates setting up a JFrame
// with a panel in its content pane. Components are added to the
// JPanel and then the panel is added to the JFrame. No user action
// happens in this class.

import javax.swing.*;

public class KiloConverterWindow extends JFrame

{
	private JPanel panel;                 // A panel container
	private JLabel messageLabel;          // A message to display
	private JTextField kiloText;          // To hold user input
	private JButton calcButton;           // Performs calculation
	private final int WINDOW_WIDTH = 320;
	private final int WINDOW_HEIGHT = 100;
	
	// Constructor
	public KiloConverterWindow()
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
		kiloText = new JTextField(10);
		calcButton = new JButton("Calculate");
		
		// Create a panel to hold the components
		panel = new JPanel();
		
		// Add the label, text field, and button to the panel
		panel.add(messageLabel);
		panel.add(kiloText);
		panel.add(calcButton);
	} 
}