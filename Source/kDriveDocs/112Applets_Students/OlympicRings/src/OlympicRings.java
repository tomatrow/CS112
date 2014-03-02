/**
 * @(#)Olympic Rings.java
 * Alan Tsunekawa * @version 1.00 09/09/07
 */
 
import javax.swing.JApplet;
import java.awt.Color;
import java.awt.Graphics;

public class OlympicRings extends JApplet
{
	// declare ring variables
	public static int outer_Ring_Diameter = 200;
	public static int inner_Ring_Diameter = 160;
	public static int inner_Ring_Offset = 20;

	// declare blue ring variables
	public static int blue_Ring_X = 180;
	public static int blue_Ring_Y = 20;
	public static int blue_Ring_Start_Angle = 289;
	
	// declare yellow ring variables
	public static int yellow_Ring_X = 290;
	public static int yellow_Ring_Y = 120;
	public static int yellow_Ring_Start_Angle = 13;
	
	// declare black ring variables
	public static int black_Ring_X = 400;
	public static int black_Ring_Y = 20;
	public static int black_Ring_Start_Angle = 289;
	
	// declare green ring variables
	public static int green_Ring_X = 510;
	public static int green_Ring_Y = 120;
	public static int green_Ring_Start_Angle = 13;
	
	// declare red ring variables
	public static int red_Ring_X = 620;
	public static int red_Ring_Y = 20;
	
	public void paint (Graphics g)
	{
		// draw blue ring and circle
		g.setColor(Color.BLUE);
		g.fillOval(blue_Ring_X,blue_Ring_Y,outer_Ring_Diameter,
		           outer_Ring_Diameter);
		// draw white interior
		g.setColor(Color.WHITE);
		g.fillOval(blue_Ring_X + inner_Ring_Offset,blue_Ring_Y +
		           inner_Ring_Offset,inner_Ring_Diameter,inner_Ring_Diameter);
		           
		// draw yellow ring and circle
		g.setColor(Color.YELLOW);
		g.fillOval(yellow_Ring_X,yellow_Ring_Y,outer_Ring_Diameter,
		           outer_Ring_Diameter);
		// draw white interior
		g.setColor(Color.WHITE);
		g.fillOval(yellow_Ring_X + inner_Ring_Offset,yellow_Ring_Y +
		           inner_Ring_Offset,inner_Ring_Diameter,inner_Ring_Diameter);
		           
		// draw black ring and circle
		g.setColor(Color.BLACK);
		g.fillOval(black_Ring_X,black_Ring_Y,outer_Ring_Diameter,
		           outer_Ring_Diameter);
		// draw white interior
		g.setColor(Color.WHITE);
		g.fillOval(black_Ring_X + inner_Ring_Offset,black_Ring_Y +
		           inner_Ring_Offset,inner_Ring_Diameter,inner_Ring_Diameter);
		           
		// draw green ring and circle
		g.setColor(Color.GREEN);
		g.fillOval(green_Ring_X,green_Ring_Y,outer_Ring_Diameter,
		           outer_Ring_Diameter);
		// draw white interior
		g.setColor(Color.WHITE);
		g.fillOval(green_Ring_X + inner_Ring_Offset,green_Ring_Y +
		           inner_Ring_Offset,inner_Ring_Diameter,inner_Ring_Diameter);
		           
		// draw red ring and circle
		g.setColor(Color.RED);
		g.fillOval(red_Ring_X,red_Ring_Y,outer_Ring_Diameter,
		           outer_Ring_Diameter);
		// draw white interior
		g.setColor(Color.WHITE);
		g.fillOval(red_Ring_X + inner_Ring_Offset,red_Ring_Y +
		           inner_Ring_Offset,inner_Ring_Diameter,inner_Ring_Diameter);
		           
		// fill in blue arc
		g.setColor(Color.BLUE);
		int i;
		for (i = 0; i <= 40; i++)
		{
			g.drawArc(blue_Ring_X + (i/2), blue_Ring_Y + (i/2),
			          outer_Ring_Diameter - i, outer_Ring_Diameter - i,
			          blue_Ring_Start_Angle + (i/4), 75);			           
		}
			          
		// fill in yellow arc
		g.setColor(Color.YELLOW);
		for (i = 0; i <= 40; i++)
		{
			g.drawArc(yellow_Ring_X + (i/2), yellow_Ring_Y + (i/2),
			          outer_Ring_Diameter - i, outer_Ring_Diameter - i,
			          yellow_Ring_Start_Angle + (i/4), 75);
		}	          
			          	          
		// fill in black arc
		g.setColor(Color.BLACK);
		for (i = 0; i <= 40; i++)
		{
			g.drawArc(black_Ring_X + (i/2), black_Ring_Y + (i/2),
			          outer_Ring_Diameter - i, outer_Ring_Diameter - i,
			          black_Ring_Start_Angle + (i/4), 75);	          
		}
			          
		// fill in green arc
		g.setColor(Color.GREEN);
		for (i = 0; i <= 40; i++)
		{
			g.drawArc(green_Ring_X + (i/2), green_Ring_Y + (i/2),
			          outer_Ring_Diameter - i, outer_Ring_Diameter - i,
			          green_Ring_Start_Angle + (i/4), 75);
		}			          		           		           		           		                     
	}
}
