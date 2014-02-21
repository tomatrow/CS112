import javax.swing.JApplet;
import java.awt.Graphics;
import java.awt.Color;

public class OlympicRings extends JApplet {
	public static final int START_X = 100;
	public static final int START_Y = 100;
	public static final int RING_DIAMETER = 100;
	public static final int RING_ALPHA = 200;

	public static final int RING_RADIUS = RING_DIAMETER/2;
	public static final int RING_INSET = RING_DIAMETER/10;
	public static final int INNER_RING_DIAMETER = RING_DIAMETER - 2*RING_INSET;
	public static final int INNER_RING_RADIUS = INNER_RING_DIAMETER/2;
	public static final int RING_OFFSET_Y = RING_RADIUS;
	public static final int RING_OFFSET_X = RING_RADIUS + RING_RADIUS/10;

	public static final Color[] COLORS_ARRAY = {Color.BLUE, Color.YELLOW, Color.BLACK, Color.GREEN, Color.RED};

	public void paint(Graphics context) {
		for (int i = 0, x = START_X, y = START_Y;i < 5 ;i++) {
			Color ringColor = new Color(COLORS_ARRAY[i].getRed(), COLORS_ARRAY[i].getGreen(), COLORS_ARRAY[i].getBlue(), RING_ALPHA);
			context.setColor(ringColor);
			drawOlmpicRing(context,x,y);
			x += RING_OFFSET_X;
			y += (i % 2 == 0)?(RING_OFFSET_Y):(RING_OFFSET_Y * (-1));
		}
	}
	private void drawOlmpicRing(Graphics context, int x, int y) {
		for (int i = 0; i < RING_INSET;i++) {
			context.drawOval(x + i, y + i, RING_DIAMETER - 2*i, RING_DIAMETER - 2*i);	
		}
	}
}