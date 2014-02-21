import javax.swing.JApplet;
import java.awt.Graphics;
import java.awt.Point;

public class AJTTDrawing {
	// happiness is an integer representing the smile on the face, from 0 - 100 
	// 0 happiness is absolue unhappy and 100 happiness is absolutly happy 
	public static void drawFace(Graphics context, Point faceCoords, int happiness, int diameter) {
		// Check for bad happiness value 
		if (happiness > 100)
			happiness = 100;
		else if (happiness < 0)
			happiness = 0;


		// Get int face coords
		int faceX = (int)faceCoords.getX();
		int faceY = (int)faceCoords.getY();

		// draw face outline 
		context.drawOval(faceX,faceY,diameter,diameter);

		// draw eyes
		int eyeLevelY = faceY + diameter / 4;
		int eyeOffSetX = diameter / 8;
		int center = diameter / 2;
		int eyeDiameter = diameter / 8;

		int leftEyeX = faceX + center - eyeOffSetX;
		int rightEyeX = faceX + center + eyeOffSetX;

		context.drawOval(leftEyeX,eyeLevelY,eyeDiameter,eyeDiameter);
		context.drawOval(rightEyeX,eyeLevelY,eyeDiameter,eyeDiameter);

		// Draw Smile
		drawSmile(context,faceCoords,happiness,diameter);
	}
	private static void drawSmile(Graphics context, Point faceCoords, int happiness, int diameter) {
		int smilePolyLineSize = 5;
		int[] smilePolyLineX = new int[smilePolyLineSize];
		int[] smilePolyLineY = new int[smilePolyLineSize];

		int radius = diameter / 2;
		int eigth = diameter / 8;
		int forth = diameter / 4;
		int fiveEighthsDown = radius + eigth;

		boolean isHappy = (happiness >= 50)?true:false;
		double happinessOffsetPercentage = Math.abs(((double)happiness-50)/100.0);
		int smileOffsetY = (int) Math.round(((double)forth) * happinessOffsetPercentage);
		int smileEndpointsY = radius + eigth + ((isHappy)?(-1 * smileOffsetY):(smileOffsetY));
		int smileMiddleY = radius + eigth + ((isHappy)?(smileOffsetY):(-1*smileOffsetY));
		
		// Set non-changing points 
		smilePolyLineY[1] = radius + eigth;
		smilePolyLineX[1] = radius - eigth;
		
		smilePolyLineY[3] = radius + eigth;
		smilePolyLineX[3] = radius + eigth;

		// Set Left, middle and right smile coords based on happiness level
		smilePolyLineX[0] = radius - eigth * 2;
		smilePolyLineX[2] = radius;
		smilePolyLineX[4] = radius + eigth * 2;

		smilePolyLineY[0] = smileEndpointsY;
		smilePolyLineY[2] = smileMiddleY;
		smilePolyLineY[4] = smileEndpointsY;

		// Take face coordenats into account
		for (int coord : smilePolyLineX) {
			coord += (int) faceCoords.getX();
		}
		for (int coord : smilePolyLineY) {
			coord += (int) faceCoords.getY();
		}


		// Draw Smile
		context.drawPolyline(smilePolyLineX, smilePolyLineY, smilePolyLineSize);
	}
}