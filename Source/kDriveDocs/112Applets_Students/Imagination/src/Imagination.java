/**
 * @(#)Imagination.java
 * Just trying out different things 
 */
 
import javax.swing.JApplet;
import java.awt.Color;
import java.awt.Graphics;

public class Imagination extends JApplet
{	
	int hallway_diameter = 100;
	int hallway_X_Start = 50;
	int hallway_Y_Start = 50;
	
	public void paint(Graphics g)
	{
		int diameterOffset;
		int directionOffset;
		int i;
		
		for (i = 60; i >= 0; i--)
		{
			diameterOffset = i * 20;
			directionOffset = i * 5;
			g.setColor(Color.BLACK);
			if ( i % 2 == 0)  // even
			{
				// make blue circle
				g. setColor(Color.BLUE);				
			}
			
			g.fillRect(hallway_X_Start - directionOffset + 10,
			           hallway_Y_Start - directionOffset,
			           hallway_diameter + diameterOffset,
			           hallway_diameter + diameterOffset); 			
		}
		
		g.setColor(Color.MAGENTA);
		g.fillOval(150, 50, 100, 100);
		g.setColor(Color.BLACK);
		g.drawOval(150, 50, 100, 100);
		g.fillOval( 173, 75, 20, 20);
		g.fillOval(200, 75, 25, 5);
		g.drawArc(175, 105, 50, 25, 180, 220);
		g.setColor(Color.DARK_GRAY);
		//g.drawString("Tee Hee.", 250, 250);
	}	
}
