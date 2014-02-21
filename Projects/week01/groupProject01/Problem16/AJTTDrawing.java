import javax.swing.JApplet;
import java.awt.*;
import java.awt.Point;
import java.awt.Graphics2D;
import java.awt.geom.Path2D.Double;
import java.awt.BasicStroke;

public class AJTTDrawing {
	// happiness is an integer representing the smile on the face, from 0 - 100 
	// 0 happiness is absolue unhappy and 100 happiness is absolutly happy 
	public static void drawFace(Graphics2D context, Point faceCoords, int happiness, int DIAMETER) {
		// Check for bad happiness value 
		if (happiness > 100)
			happiness = 100;
		else if (happiness < 0)
			happiness = 0;


		// Get int face coords
		int FACE_X = (int)faceCoords.getX();
		int FACE_Y = (int)faceCoords.getY();

		// draw face outline 
		context.drawOval(FACE_X,FACE_Y,DIAMETER,DIAMETER);

		// draw eyes
		int EYE_LEVEL_Y = FACE_Y + DIAMETER / 4;
		int EYE_OFFSET_X = DIAMETER / 8;
		int RADIUS = DIAMETER / 2;
		int EYE_DIAMETER = DIAMETER / 8;

		int LEFT_EYE_X = FACE_X + RADIUS - EYE_OFFSET_X - EYE_DIAMETER;
		int RIGHT_EYE_X = FACE_X + RADIUS + EYE_OFFSET_X;

		context.drawOval(LEFT_EYE_X,EYE_LEVEL_Y,EYE_DIAMETER,EYE_DIAMETER);
		context.drawOval(RIGHT_EYE_X,EYE_LEVEL_Y,EYE_DIAMETER,EYE_DIAMETER);

		// Draw Smile
		drawSmile(context,faceCoords,happiness,DIAMETER);
	}
	private static void drawSmile(Graphics2D context, Point faceCoords, int happiness, int DIAMETER) {
		int smilePolyLineSize = 5;
		int[] smilePolyLineX = new int[smilePolyLineSize];
		int[] smilePolyLineY = new int[smilePolyLineSize];

		int radius = DIAMETER / 2;
		int eigth = DIAMETER / 8;
		int FORTH_DIAMETER = DIAMETER / 4;
		int fiveEighthsDown = radius + eigth;


		// Draw Smile
		// context.drawPolyline(smilePolyLineX, smilePolyLineY, smilePolyLineSize);
		java.awt.geom.Path2D.Double arc = new java.awt.geom.Path2D.Double();
		arc.moveTo(faceCoords.getX() + FORTH_DIAMETER,faceCoords.getY() + radius + eigth);

		// Happiness level
		boolean isHappy = (happiness >= 50)?true:false;
		double HAPPINESS_OFFSET_PERCENTAGE = Math.abs(((double)happiness-50)/100.0);
		double HAPPINESS_OFFSET = HAPPINESS_OFFSET_PERCENTAGE * FORTH_DIAMETER;


		// Initial Values
		double SMILE_START_X = faceCoords.getX() + FORTH_DIAMETER;
		double SMILE_START_Y = faceCoords.getY() + radius + eigth;
		double SMILE_MIDDLE_X = faceCoords.getX() + radius;
		double SMILE_MIDDLE_Y = SMILE_START_Y;
		double SMILE_END_X = faceCoords.getX() + radius + FORTH_DIAMETER;
		double SMILE_END_Y = SMILE_START_Y;

		SMILE_MIDDLE_Y += (isHappy)?HAPPINESS_OFFSET:-1*HAPPINESS_OFFSET;

		arc.curveTo(SMILE_START_X,SMILE_START_Y,SMILE_MIDDLE_X,SMILE_MIDDLE_Y,SMILE_END_X, SMILE_END_Y);

		BasicStroke s = new BasicStroke(3.0f);
		context.draw(s.createStrokedShape(arc));
	}
}