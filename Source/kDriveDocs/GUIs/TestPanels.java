// This example demonstrates using panels as subcontainers
// The program creates a user interface for a microwave oven
// and the panels are used to organize components.

import javax.swing.*;
import java.awt.*;

public class TestPanels extends JFrame
{
	public TestPanels()
	{
	// create panel p1 for the buttons and set Gridlayout
	JPanel p1 = new JPanel();
	p1.setLayout(new GridLayout(4,3));
	
	// add buttons to the panel
	for (int i = 1; i <= 9; i++)
	{
		p1.add(new JButton("" + i));
	}
	
	p1.add(new JButton("" + 0));
	p1.add(new JButton("Start"));
	p1.add(new JButton("Stop"));
	
	// create a panel p2 to hold a text field and pl
	JPanel p2 = new JPanel(new BorderLayout());
	p2.add(new JTextField("Time to be displayed here."));
	p2.add(p1, BorderLayout.CENTER);
	
	// add contents into the frame
	add(p2, BorderLayout.EAST);
	add(new JButton("Food to be placed here"),   //note continuation of line
	BorderLayout.CENTER);
	}

// Main method
	public static void main(String[] args)
	{
		TestPanels frame = new TestPanels();
	
		frame.setTitle("The Front View of a Microwave Oven");
		frame.setLocationRelativeTo(null);                 // center the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 250);
		frame.setVisible(true);
	}	
}