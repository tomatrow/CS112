/* Chapter No. NA. - Project No.  NA.
    File Name:          Problem11.java
    Programmer:         Andrew Caldwell
    Date Last Modified: Jan. 24, 2014

    Problem Statement:
    Draw a circle within a square. 

    Overall Plan
	* Draw square
	* Draw Circle

    Classes needed and Purpose
    main class - Problem11
    Graphics - context
*/

import javax.swing.JApplet;
import java.awt.Graphics;
import java.awt.Color;

public class Problem11 extends JApplet {
	public static final int START_X = 100;
	public static final int START_Y = 100;
	public static final int RING_DIAMETER = 100;
	public static final int RING_RADIUS = RING_DIAMETER/2;

	public static final int SQUARE_EDGE = RING_DIAMETER;

	public static final Color[] COLORS_ARRAY = {Color.PINK, Color.BLUE, Color.YELLOW, Color.BLACK, Color.GREEN, Color.RED};

	public void paint(Graphics context) {
		context.setColor(Color.PINK);
		context.drawRect(START_X,START_Y,SQUARE_EDGE,SQUARE_EDGE);
		context.setColor(Color.RED);
		context.drawOval(START_X,START_Y,RING_DIAMETER,RING_DIAMETER);
	}
}