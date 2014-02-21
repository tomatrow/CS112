/* Chapter No. NA. - Project No.  NA.
    File Name:          Problem14.java
    Programmer:         Andrew Caldwell
    Date Last Modified: Jan. 24, 2014

    Problem Statement:
    Draw a crescent moon, outline and inside in different colors. 

    Overall Plan
	* Draw bull's eye pattern with alternating blue and green. 

    Classes needed and Purpose
    main class - Problem14
    Graphics - context
*/

import javax.swing.JApplet;
import java.awt.Graphics;
import java.awt.Color;

public class Problem14 extends JApplet {
	public static final int START_X = 100;
	public static final int START_Y = 100;
	public static final int RING_DIAMETER = 100;
	public static final int RING_INSET = RING_DIAMETER/10;

	public static final Color[] COLORS_ARRAY = {Color.PINK, Color.BLUE, Color.YELLOW, Color.BLACK, Color.GREEN, Color.RED};
	public void paint(Graphics context) {

		for (int i = 0; i < 5;i++) {
			// Alternate colors between blue and green 
			if (context.getColor() != Color.BLUE) {
				context.setColor(Color.BLUE);
			} else  {
				context.setColor(Color.GREEN);
			}


			context.fillOval(START_X+ RING_INSET*i/2, START_Y + RING_INSET*i/2, RING_DIAMETER - RING_INSET*i, RING_DIAMETER - RING_INSET*i);
		}

	}
}