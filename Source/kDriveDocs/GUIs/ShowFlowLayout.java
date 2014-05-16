// This example demonstrates using the FlowLayout Manager
// The components are added in a row Left to Right, and when
// a row is filled, a new row is created.
// If the frame is resized, the components may be rearranged.

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFrame;
import java.awt.FlowLayout;

public class ShowFlowLayout extends JFrame
{
	public ShowFlowLayout()
	{
	// set FlowLayout aligned left with horizontal gap 10
	// and vertical gap 20 between components
	setLayout (new FlowLayout(FlowLayout.LEFT, 10, 20));
	
	// add labels and textfields to the frame
	add(new JLabel("First Name"));
	add(new JTextField(8));
	add(new JLabel("MI"));
	add(new JTextField(1));
	add(new JLabel("Last Name"));
	add(new JTextField(8));
}

// Main method
	public static void main(String[] args)
	{
		ShowFlowLayout frame = new ShowFlowLayout();
	
		frame.setTitle("ShowFlowLayout");
		frame.setLocationRelativeTo(null);       // center the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(200, 200);
		frame.setVisible(true);
	}	
}