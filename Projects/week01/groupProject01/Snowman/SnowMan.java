import javax.swing.JApplet;
import java.awt.Graphics;

public class SnowMan extends JApplet {
	public static final int START_X = 500;
	public static final int START_Y = 100;

	public static final int BASE_DIAMETER = 150;
	public static final int DIAMETER_OFFSET = BASE_DIAMETER / 3;
	public static final int BASE_RADIUS = BASE_DIAMETER / 2;
	public static final int BASE_DIAMETER_TRIANGLE_LEG = (int)(((double)BASE_DIAMETER) * Math.sin(Math.PI / 4));

	// Body
	public static final int BOTTOM_DIAMETER = BASE_DIAMETER;
	public static final int MIDDLE_DIAMETER = BASE_DIAMETER - DIAMETER_OFFSET;
	public static final int TOP_DIAMETER = BASE_DIAMETER - 2*DIAMETER_OFFSET;

	public static final int BOTTOM_RADIUS = BOTTOM_DIAMETER/2;
	public static final int MIDDLE_RADIUS = MIDDLE_DIAMETER/2;
	public static final int TOP_RADIUS = TOP_DIAMETER/2;

	public static final int TOTAL_HEIGHT = TOP_DIAMETER + MIDDLE_DIAMETER + BOTTOM_DIAMETER;

	// Eyes
	public static final int EYE_DIAMETER = TOP_DIAMETER / 8;
	public static final int EYE_OFFSET = EYE_DIAMETER + EYE_DIAMETER/5;
	public static final int EYE_LEVEL = START_Y + TOP_RADIUS/2;
	public static final int EYE_X_LEFT = START_X + BASE_RADIUS - EYE_DIAMETER - EYE_OFFSET;
	public static final int EYE_X_RIGHT = START_X + BASE_RADIUS + EYE_OFFSET;

	// Smile 
	public static final int SMILE_DIAMETER = (int)(TOP_DIAMETER * 0.75); 	
	public static final int SMILE_RADIUS = SMILE_DIAMETER / 2;	
	public static final int SMILE_X = START_X + BASE_RADIUS - SMILE_RADIUS;
	public static final int SMILE_Y = START_Y + TOP_RADIUS / 4;

	// Arms
	public static final int RIGHT_BRANCH_START_X = START_X + BASE_RADIUS + MIDDLE_RADIUS;
	public static final int RIGHT_BRANCH_START_Y = START_Y + TOP_DIAMETER + MIDDLE_RADIUS;
	public static final int RIGHT_BRANCH_MIDDLE_X = RIGHT_BRANCH_START_X + BASE_DIAMETER_TRIANGLE_LEG/2;
	public static final int RIGHT_BRANCH_MIDDLE_Y = RIGHT_BRANCH_START_Y + BASE_DIAMETER_TRIANGLE_LEG/2;
	public static final int RIGHT_BRANCH_END_X = RIGHT_BRANCH_MIDDLE_X + BASE_DIAMETER_TRIANGLE_LEG/2;
	public static final int RIGHT_BRANCH_END_Y = RIGHT_BRANCH_START_Y;


	public static final int LEFT_BRANCH_START_X = START_X + BASE_RADIUS - MIDDLE_RADIUS;
	public static final int LEFT_BRANCH_START_Y = RIGHT_BRANCH_START_Y;
	public static final int LEFT_BRANCH_MIDDLE_X = LEFT_BRANCH_START_X - BASE_DIAMETER_TRIANGLE_LEG/2;
	public static final int LEFT_BRANCH_MIDDLE_Y = LEFT_BRANCH_START_Y + BASE_DIAMETER_TRIANGLE_LEG/2;
	public static final int LEFT_BRANCH_END_X = LEFT_BRANCH_MIDDLE_X - BASE_DIAMETER_TRIANGLE_LEG/2;
	public static final int LEFT_BRANCH_END_Y = LEFT_BRANCH_START_Y;

	public void paint(Graphics context) {
		// Draw Body
		context.drawOval(START_X,START_Y + TOP_DIAMETER+MIDDLE_DIAMETER,BOTTOM_DIAMETER,BOTTOM_DIAMETER);// bottom
		context.drawOval(START_X + (BASE_DIAMETER - MIDDLE_DIAMETER)/2,START_Y+TOP_DIAMETER,MIDDLE_DIAMETER,MIDDLE_DIAMETER);//middle
		context.drawOval(START_X + (BASE_DIAMETER - TOP_DIAMETER)/2,START_Y,TOP_DIAMETER,TOP_DIAMETER);//top

		// Draw Eyes
		context.fillOval(EYE_X_LEFT,EYE_LEVEL,EYE_DIAMETER,EYE_DIAMETER);
		context.fillOval(EYE_X_RIGHT,EYE_LEVEL,EYE_DIAMETER,EYE_DIAMETER);

		// Draw Smile 
		context.drawArc(SMILE_X,SMILE_Y,SMILE_DIAMETER,SMILE_DIAMETER,180,180);

		// Draw Arms
		int[] rightArmX = {RIGHT_BRANCH_START_X,RIGHT_BRANCH_MIDDLE_X,RIGHT_BRANCH_END_X};
		int[] rightArmY = {RIGHT_BRANCH_START_Y,RIGHT_BRANCH_MIDDLE_Y,RIGHT_BRANCH_END_Y};
		context.drawPolyline(rightArmX,rightArmY,rightArmX.length);

		int[] leftArmX = {LEFT_BRANCH_START_X,LEFT_BRANCH_MIDDLE_X,LEFT_BRANCH_END_X};
		int[] leftArmY = {LEFT_BRANCH_START_Y,LEFT_BRANCH_MIDDLE_Y,LEFT_BRANCH_END_Y};
		context.drawPolyline(leftArmX,leftArmY,leftArmX.length);
	}
}