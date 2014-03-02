// ChristmasTrees.java
// Student - Kurt Mueller
 
import java.awt.*;
import java.applet.*;
import java.util.Scanner;

public class ChristmasTrees extends Applet
{	
	public static final int CANVAS_WIDTH = 600;
	public static final int CANVAS_HEIGHT = CANVAS_WIDTH;
	int iterations;
	
	public void init()
	{
		// Set canvas size & background
		setSize(CANVAS_WIDTH, CANVAS_HEIGHT);
		setBackground(Color.WHITE);
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Enter the # of iterations between 1 and 12: ");
		iterations = keyboard.nextInt();		
	}
    
	public void paint(Graphics g) 
	{
		//int iterations;
		int x_coord = 0, y_coord = 0;
		int width = CANVAS_WIDTH, height = CANVAS_HEIGHT;
				
		for (int i = 0; i < iterations; i++)
		{
			g.setColor(Color.GREEN);
			g.fillOval(x_coord, y_coord, width, height);
			
			g.setColor(Color.RED);
			g.fillOval(x_coord, y_coord, width/2, height/2);
			g.fillOval(x_coord + (width/2), y_coord, width/2, height/2);
			g.fillOval(x_coord, y_coord + (width/2), width/2, height/2);
			g.fillOval(x_coord + (width/2), y_coord + (width/2), width/2, height/2);
			
			x_coord +=25;
			y_coord = x_coord;
			width -= 50;
			height = width;
			
		}
	}
}
