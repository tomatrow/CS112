// This class demonstrates how to set the background color of a
// panel and the foreground color of a label.

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;                  //Needed for the Color class

public class ColorWindow extends JFrame
{
	private JPanel panel;
	private JLabel msgLabel;
	private JButton redButton;
	private JButton blueButton;
	private JButton yellowButton;
	private final int WINDOW_WIDTH = 220;
	private final int WINDOW_HEIGHT = 125;
	
	// Constructor
	
	public ColorWindow()
	{
		// Set the title bar text, window size and action for close button
		super("Colors");
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Create label to display message
		msgLabel = new JLabel("Click a button to select a color.");
		
		// Create three buttons
		redButton = new JButton("Red");
		blueButton = new JButton("Blue");
		yellowButton = new JButton("Yellow");
		
		// Register an event listener with all 3 buttons
		redButton.addActionListener(new RedButtonListener());
		blueButton.addActionListener(new BlueButtonListener());
		yellowButton.addActionListener(new YellowButtonListener());
		
		// Create a panel and add the components to it.
		panel = new JPanel();
		panel.add(msgLabel);
		panel.add(redButton);
		panel.add(blueButton);
		panel.add(yellowButton);
		
		// Add the panel to content pane and display window
		add(panel);
		setVisible(true);
		setLocationRelativeTo(null);
	}
	
	// Private inner classes that handles the events when the user clicks
	// the different color buttons
	private class RedButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			panel.setBackground(Color.red);
			msgLabel.setForeground(Color.yellow);
		}
	}
	
		private class BlueButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			panel.setBackground(Color.blue);
			msgLabel.setForeground(Color.pink);
		}
	}
	
	private class YellowButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			panel.setBackground(Color.black);
			msgLabel.setForeground(Color.yellow);
		}
	}

}


