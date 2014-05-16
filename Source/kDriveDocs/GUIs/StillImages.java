// This program demonstrates displaying icons in a label
// and on a button.

import java.awt.*;
import javax.swing.*;
import java.util.*;

public class StillImages extends JFrame
{
	private ImageIcon bottle = new ImageIcon("images/cokebott.jpg");
	private ImageIcon inc = new ImageIcon("images/cokeinc.jpg");
	private ImageIcon coke = new ImageIcon("images/coke.gif");
	private ImageIcon dragon = new ImageIcon("images/cokpi100.gif");
	private ImageIcon car = new ImageIcon("images/ferrari.jpg");
	
	public StillImages()
	{
		setLayout(new GridLayout(2, 2, 5, 5));
		add(new JLabel(bottle));
		add(new JLabel(inc));
		add(new JLabel(coke));
		add(new JLabel(dragon));
	}
	
	public StillImages(int value)
	{
		setLayout(new GridLayout(1, 1));
		add(new JLabel(car));
	}
	
	public static void main(String[] args)
	{
		int response;
		System.out.println("View pitures of coke or a car?");
		System.out.println("Enter c for coke or f for car.");
		Scanner keyboard = new Scanner(System.in);
		response = keyboard.nextLine().charAt(0);
		
		if ((response == 'C') || (response == 'c'))
		{
			StillImages frame = new StillImages();
			frame.setTitle("View Images");
			frame.setSize(450, 450);
			frame.setLocationRelativeTo(null);    // Center the frame
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		}
		else
		{
			int number = 2;
			StillImages frame = new StillImages(number);
			frame.setTitle("View the Ferrari");   // Use second constructor
			frame.setSize(1000, 600);
			frame.setLocationRelativeTo(null);    // Center the frame
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		}
		
	}
}