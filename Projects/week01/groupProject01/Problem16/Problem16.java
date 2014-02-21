/* Chapter No. NA. - Project No.  NA.
    File Name:          Problem16.java
    Programmer:         Andrew Caldwell
    Date Last Modified: Jan. 24, 2014

    Problem Statement:
	Use you imagination to draw things 

    Overall Plan:
    loop i from  0 to 10
	    Set context from color array 
    	if i = 5
	    	set x to 0
	    	set y to diameter
	    draw face
	    incement happiness
	    increment x 

    Classes needed and Purpose
    main class - Problem16
    Graphics - context
    AJTTDrawing - drawing faces with happiness 
*/

import javax.swing.JApplet;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Point;

public class Problem16 extends JApplet {
	public static final int FACE_DIAMETER = 100;
	public static final int FACE_RADIUS = FACE_DIAMETER / 2;
	public static final int HAPPINESS_OFFSET = 10;
	public static final Color[] COLORS = {Color.BLACK, Color.BLUE, Color.CYAN, Color.GREEN, Color.MAGENTA, Color.ORANGE,Color.PINK, Color.RED, Color.WHITE, Color.YELLOW};
	public static final int START_X = 100;
	public static final int START_Y = 100;

	public void paint(Graphics context) {
		Graphics2D context2D = (Graphics2D)context;
		int happiness = 0;

		for (int i = 0, x = START_X, y = START_Y;i < 10;i++) {
			context.setColor(COLORS[i]);
			if (i == 5) {
				// change path midway
				x = START_X;
				y = START_Y + FACE_DIAMETER;
			}
			AJTTDrawing.drawFace(context2D,new Point(x,y),happiness,FACE_DIAMETER);
			happiness += HAPPINESS_OFFSET;
			x += FACE_DIAMETER;
		}
	}
}

