/* Chapter No. NA. - Project No.  NA.
    File Name:          Problem12.java
    Programmer:         Andrew Caldwell
    Date Last Modified: Jan. 24, 2014

    Problem Statement:
    Draw a crescent moon, outline and inside in different colors. 

    Overall Plan
	* Draw square
	* Draw Circle

    Classes needed and Purpose
    main class - Problem12
    Graphics - context
*/

import javax.swing.JApplet;
import java.awt.Graphics;
import java.awt.Color;

public class Problem12 extends JApplet {
	public static final int START_X = 100;
	public static final int START_Y = 100;
	public static final int RING_DIAMETER = 100;

	public static final int OVAL_DIAMETER_X = RING_DIAMETER;
	public static final int OVAL_DIAMETER_Y = (RING_DIAMETER * 3) / 4;

	public static final Color[] COLORS_ARRAY = {Color.PINK, Color.BLUE, Color.YELLOW, Color.BLACK, Color.GREEN, Color.RED};
	public void init() {
		setBackground(Color.BLUE);
	}
	public void paint(Graphics context) {
		// int box_width = 30;
		// for (int i = 0, x = START_X, y = START_Y;i < COLORS_ARRAY.length;i++) {
		// 	context.setColor(COLORS_ARRAY[i]);
		// 	context.fillRect(x,y,box_width,100);	
		// 	x+= box_width;
		// }

		context.setColor(Color.RED);
		context.fillRect(0,0,1000,300);

		context.setColor(Color.PINK);
		context.fillOval(START_X,START_Y,100,100);
		context.setColor(Color.RED);
		context.fillOval(START_X,START_Y,100,75);
	}
}