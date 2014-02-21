import javax.swing.JApplet;
import java.awt.Graphics;
import java.awt.Color;
public class MultipleFaces extends JApplet {
	public static final int FACE_DIAMETER = 50;
	public static final int X_FACE0 = 10;
	public static final int Y_FACE0 = 5;
	public static final int EYE_WIDTH = 5;
	public static final int EYE_HEIGHT = 10;
	public static final int X_RIGHT_EYE0 = 20;
	public static final int Y_RIGHT_EYE0 = 15;
	public static final int X_LEFT_EYE0 = 45;
	public static final int Y_LEFT_EYE0 = Y_RIGHT_EYE0;
	public static final int NOSE_DIAMETER = 5;
	public static final int X_NOSE0 = 32;
	public static final int Y_NOSE0 = 25;
	public static final int MOUTH_WIDTH = 30;
	public static final int MOUTH_HEIGHT0 = 0;
	public static final int X_MOUTH0 = 20;
	public static final int Y_MOUTH0 = 35;
	public static final int MOUTH_START_ANGLE = 180;
	public static final int MOUTH_EXTENT_ANGLE = 180;
	public void paint(Graphics canvas) 
	{
		int i, xOffset, yOffset; //Want i to exist after the loop ends 
		for (i = 0; i <= 4; i++)
		{ //Draw one face:
            xOffset = 50 * i;
            yOffset = 30 * i;
			//Draw face circle:
			if (i % 2 == 0) //if i is even
			{ //Make face light gray 
				canvas.setColor(Color.LIGHT_GRAY); 
				canvas.fillOval(X_FACE0 + xOffset, Y_FACE0 + 30 * i, FACE_DIAMETER, FACE_DIAMETER);
			}
	        canvas.setColor(Color.BLACK);
	        canvas.drawOval(X_FACE0 + xOffset, Y_FACE0 + yOffset, FACE_DIAMETER, FACE_DIAMETER);


			//Draw eyes:
			canvas.setColor(Color.BLUE); canvas.fillOval(X_RIGHT_EYE0 + xOffset, Y_RIGHT_EYE0 + yOffset, EYE_WIDTH, EYE_HEIGHT);
			canvas.fillOval(X_LEFT_EYE0 + xOffset, Y_LEFT_EYE0 + yOffset, EYE_WIDTH, EYE_HEIGHT);
			//Draw nose:
			canvas.setColor(Color.BLACK);
			canvas.fillOval(X_NOSE0 + xOffset, Y_NOSE0 + yOffset, NOSE_DIAMETER, NOSE_DIAMETER);
			//Draw mouth:
			canvas.setColor(Color.RED);
			canvas.drawArc(X_MOUTH0 + xOffset, Y_MOUTH0 + yOffset, MOUTH_WIDTH, MOUTH_HEIGHT0 + 3 * i, MOUTH_START_ANGLE, MOUTH_EXTENT_ANGLE);
		}
		
		//i is 5 when the previous loop ends
		xOffset = 50 * i;
		yOffset = 30 * i;

		//Draw kissing face:
		//Draw face outline:
		canvas.setColor(Color.BLACK);
		canvas.drawOval(X_FACE0 + xOffset, Y_FACE0 + yOffset, FACE_DIAMETER, FACE_DIAMETER);
		//Draw eyes:
		canvas.setColor(Color.BLUE);
		canvas.fillOval(X_RIGHT_EYE0 + xOffset, Y_RIGHT_EYE0 + yOffset, EYE_WIDTH, EYE_HEIGHT);
		canvas.fillOval(X_LEFT_EYE0 + xOffset, Y_LEFT_EYE0 + yOffset, EYE_WIDTH, EYE_HEIGHT);
		//Draw nose:
		canvas.setColor(Color.BLACK);
		canvas.fillOval(X_NOSE0 + xOffset, Y_NOSE0 + yOffset, NOSE_DIAMETER, NOSE_DIAMETER);
		//Draw mouth in shape of a kiss:
		canvas.setColor(Color.RED);
		canvas.fillOval(X_MOUTH0 + xOffset + 10, Y_MOUTH0 + yOffset, MOUTH_WIDTH - 20, MOUTH_WIDTH - 20);


		//Add text:
		canvas.drawString("Kiss, Kiss.",
		X_FACE0 + xOffset + FACE_DIAMETER, Y_FACE0 + yOffset);
		//Draw blushing face:
		i++;
		xOffset = 50 * i;
		yOffset = 30 * i;
		//Draw face circle:
		canvas.setColor(Color.GRAY);
		canvas.fillOval(X_FACE0 + xOffset, Y_FACE0 + yOffset,
		                FACE_DIAMETER, FACE_DIAMETER);
		canvas.setColor(Color.BLACK);
		canvas.drawOval(X_FACE0 + xOffset, Y_FACE0 + yOffset,
		                FACE_DIAMETER, FACE_DIAMETER);
		//Draw eyes:
		canvas.setColor(Color.BLACK);
		canvas.fillOval(X_RIGHT_EYE0 + xOffset, Y_RIGHT_EYE0 +
		yOffset, EYE_WIDTH, EYE_HEIGHT); canvas.fillOval(X_LEFT_EYE0 + xOffset, Y_LEFT_EYE0 + yOffset,
		               EYE_WIDTH, EYE_HEIGHT);
		//Draw nose:
		canvas.setColor(Color.BLACK);
		canvas.fillOval(X_NOSE0 + xOffset, Y_NOSE0 + yOffset,
		                NOSE_DIAMETER, NOSE_DIAMETER);
		//Draw mouth:
		canvas.setColor(Color.BLACK);
		canvas.drawArc(X_MOUTH0 + xOffset, Y_MOUTH0 + yOffset,
		               MOUTH_WIDTH, MOUTH_HEIGHT0 + 3 * (i - 2),
		               MOUTH_START_ANGLE, MOUTH_EXTENT_ANGLE);
		//Add text:
		canvas.drawString("Tee Hee.",
		X_FACE0 + xOffset + FACE_DIAMETER, Y_FACE0 + yOffset);
	}
}