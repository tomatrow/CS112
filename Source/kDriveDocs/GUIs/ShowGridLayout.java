// This example demonstrates using the GridLayout Manager
// The container is divided into grids, and the components
// are added to fill in the cells row by row.
// When a row is filled, a new row is created.
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFrame;
import java.awt.GridLayout;

public class ShowGridLayout extends JFrame
{
	public ShowGridLayout()
	{
	// set ShowGridLayout, 3 rows, 2 columns, and gaps 5
	// between components horizontally and vertically
	setLayout (new GridLayout(3, 2, 5, 5));
	
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
		ShowGridLayout frame = new ShowGridLayout();
	
		frame.setTitle("ShowGridLayout");
		frame.setLocationRelativeTo(null);       // center the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(200, 125);
		frame.setVisible(true);
	}	
}