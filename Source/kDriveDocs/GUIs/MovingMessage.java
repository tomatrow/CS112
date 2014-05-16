// This program demonstrates the Swing Timer class. This class can be
// used to fire an event and control animation.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MovingMessage extends JFrame
{
	public MovingMessage()
	{
		// Create a panel to display a moving message
		add(new MovingMessagePanel("Whee - I'm moving!"));
	}
	
	public static void main(String[] args)
	{
		MovingMessage frame = new MovingMessage();
		frame.setTitle("Watch me move...");
		frame.setSize(350, 100);
		frame.setLocationRelativeTo(null);    // Center the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	// Inner class: Displays the moving message
	static class MovingMessagePanel extends JPanel
	{
		private String message = "Whee - I'm moving!";
		private int xCoordinate = 0;
		private int yCoordinate = 20;
		
		public MovingMessagePanel(String message)
		{
			this.message = message;
			
			// Create a timer
			// The smaller the delay (200), the faster the message moves
			Timer timer = new Timer(200, new TimerListener());
			timer.start();
		}
		
		// Paint message
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
		
			if (xCoordinate > getWidth())
			{
				xCoordinate = -20;
			}
			xCoordinate += 30;
			g.drawString(message, xCoordinate, yCoordinate);
		}
	
		class TimerListener implements ActionListener
		{
			// Handle ActionEvent
			public void actionPerformed(ActionEvent e)
			{
				repaint();
			}
		}	
	}
}
