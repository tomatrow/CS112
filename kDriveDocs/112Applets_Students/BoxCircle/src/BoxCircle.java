/**
 * @(#)BoxCircle.java
 *
 * Sample Applet application:
 * 1. Call Graphics method Paint
 * 2. Draw a box
 * 3. Draw a circle. The circle will have the same parameters as the box.
 * 4. The length of the box in the circle is the diameter divided by the 
 *    square root of 2. The X-Y displacement is 1/2 the difference of the 
 *    diameter of the circle and the length of the inside square. 
 */
 
import javax.swing.JApplet;
import java.awt.Graphics;
import java.awt.Color;

public class BoxCircle extends JApplet
{
	// declare white square variables
	public static int white_length = 500;
	public static int white_X = 50;
	public static int white_Y = 50;
	
	// declare blue square variables
	public static int blue_length = 354;
	public static int blue_X = 123;
	public static int blue_Y = 123;
	
	// declare yellow square variables
	public static int yellow_length = 250;
	public static int yellow_X = 175;
	public static int yellow_Y = 175;
	
	// declare orange square variables
	public static int orange_length = 177;
	public static int orange_X = 212;
	public static int orange_Y = 212;
	
	public void paint (Graphics g)
	{
		// draw white box with black outline
		g.drawRect(white_X, white_Y, white_length, white_length);
		
		// draw black circle
		g.fillOval(white_X, white_Y, white_length, white_length);
		
		// draw blue box
		g.setColor(Color.BLUE);
		g.fillRect(blue_X, blue_Y, blue_length, blue_length);
		
		// draw red circle
		g.setColor(Color.RED);
		g.fillOval(blue_X, blue_Y, blue_length, blue_length);
		
		// draw yellow box
		g.setColor(Color.YELLOW);
		g.fillRect(yellow_X, yellow_Y, yellow_length, yellow_length);
		
		// draw green circle
		g.setColor(Color.GREEN);
		g.fillOval(yellow_X, yellow_Y, yellow_length, yellow_length);
		
		// draw orange box
		g.setColor(Color.ORANGE);
		g.fillRect(orange_X, orange_Y, orange_length, orange_length);
		
		// draw magenta circle
		g.setColor(Color.MAGENTA);
		g.fillOval(orange_X, orange_Y, orange_length, orange_length);
	}
}