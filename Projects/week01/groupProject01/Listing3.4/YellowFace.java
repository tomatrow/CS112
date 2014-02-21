import javax.swing.JApplet;
import java.awt.Graphics;
import java.awt.Color;

public class YellowFace extends JApplet {
	public static final int FACE_DIAMETER = 200;
	public static final int FACE_RADIUS = FACE_DIAMETER / 2;
	public static final int X_FACE = 100;
	public static final int Y_FACE = 100;

	public static final int EYE_WIDTH = FACE_DIAMETER/20;
	public static final int EYE_HEIGHT = EYE_WIDTH * 2;
	public static final int EYE_OFFSET = EYE_WIDTH * 3;
	public static final int X_RIGHT_EYE = X_FACE + FACE_RADIUS + EYE_OFFSET;
	public static final int Y_RIGHT_EYE = Y_FACE + FACE_DIAMETER / 4;
	public static final int X_LEFT_EYE = X_FACE + FACE_RADIUS + - EYE_OFFSET - EYE_WIDTH;
	public static final int Y_LEFT_EYE = Y_RIGHT_EYE;

	public static final int NOSE_DIAMETER = EYE_WIDTH;
	public static final int X_NOSE = X_FACE + FACE_DIAMETER/2 - NOSE_DIAMETER / 2;
	public static final int Y_NOSE = Y_FACE + FACE_DIAMETER/2 - (3 * NOSE_DIAMETER) / 2;

	public static final int MOUTH_WIDTH = FACE_DIAMETER / 2;
	public static final int MOUTH_HEIGHT = MOUTH_WIDTH / 2;
	public static final int X_MOUTH = X_FACE + FACE_DIAMETER / 4;
	public static final int Y_MOUTH = Y_FACE + FACE_DIAMETER / 2 + FACE_DIAMETER / 20;
	public static final int MOUTH_START_ANGLE = 180;
	public static final int MOUTH_EXTENT_ANGLE = 180;



	public void paint(Graphics context) {
		// Draw face interior and outline
		context.setColor(Color.YELLOW);
		context.fillOval(X_FACE,Y_FACE,FACE_DIAMETER,FACE_DIAMETER);
		context.setColor(Color.BLACK);
		context.drawOval(X_FACE,Y_FACE,FACE_DIAMETER,FACE_DIAMETER);

		// Draw eyes
		context.setColor(Color.BLUE);
		context.fillOval(X_RIGHT_EYE,Y_RIGHT_EYE,EYE_WIDTH,EYE_HEIGHT);
		context.fillOval(X_LEFT_EYE,Y_LEFT_EYE,EYE_WIDTH,EYE_HEIGHT);

		// Draw Nose
		context.setColor(Color.BLACK);
		context.fillOval(X_NOSE,Y_NOSE,NOSE_DIAMETER,NOSE_DIAMETER);

		// Draw mouth
		context.setColor(Color.RED);
		context.drawArc(X_MOUTH,Y_MOUTH,MOUTH_WIDTH,MOUTH_HEIGHT,MOUTH_START_ANGLE,MOUTH_EXTENT_ANGLE);
	}
}