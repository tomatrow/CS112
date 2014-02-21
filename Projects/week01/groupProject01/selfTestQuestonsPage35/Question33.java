import javax.swing.JApplet;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

public class Question33 extends JApplet{
	public static final int FACE_DIAMETER = 200;
	public static final int EYE_DIAMETER = 20;
	public static final int EYE_OFFSET = 200;

	public void paint(Graphics context) {     
		context.drawOval(100,50,FACE_DIAMETER,FACE_DIAMETER);
		context.fillOval(155,100,EYE_DIAMETER,EYE_DIAMETER);
		context.fillOval(230,100,EYE_DIAMETER,EYE_DIAMETER);
		context.drawArc(150,160,100,50,180,180);
	}
}
