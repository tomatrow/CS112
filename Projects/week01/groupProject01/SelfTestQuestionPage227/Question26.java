import javax.swing.JApplet;
import java.awt.Graphics;
import java.awt.Color;

public class Question26 extends JApplet {
	public static final int START_X = 100;
	public static final int START_Y = 100;
	public static final int RING_DIAMETER = 100;
	public static final int RING_RADIUS = RING_DIAMETER/2;

	public static final Color[] COLORS_ARRAY = {Color.PINK, Color.BLUE, Color.YELLOW, Color.BLACK, Color.GREEN, Color.RED};

	public void paint(Graphics context) {
		for (int i = 0, x = START_X,y = START_Y;i < 6;i++) {
			context.setColor(COLORS_ARRAY[i]);
			context.fillOval(x,y,RING_DIAMETER,RING_DIAMETER);
			context.setColor(Color.BLACK);
			context.drawOval(x,y,RING_DIAMETER,RING_DIAMETER);
			x += RING_DIAMETER + RING_RADIUS;
		}
	}
}