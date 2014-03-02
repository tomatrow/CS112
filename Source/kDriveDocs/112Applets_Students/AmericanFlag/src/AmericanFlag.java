// AmericanFlag.java
// Designer: Jason Shelton
 
import java.awt.*;
import java.applet.*;

public class AmericanFlag extends Applet
{	
	
	public static final int START_X = 5;
	public static final int START_Y = 5;
	public static final int WIDTH = 500;
	public static final int HEIGHT = 260;
	public static final int STAR_XO = 40;
	public static final int STAR_X1 = 40;
	public static final int STAR_Y = 15;

	public void paint(Graphics g)
	{
		for (int i = 0; i <= 13; i++)
		{
			if ((i % 2) == 0)g.setColor(Color.red);
			else g.setColor(Color.white);
			g.fillRect(START_X, START_Y + i * 20, WIDTH, 20);			
		}
		g.setColor(Color.BLUE);
		g.fillRect(START_X, START_Y, 220, 140);
		
		g.setColor(Color.white);
		for (int a = 0; a <= 8; a++)
		{
			if ((a % 2) == 0)
			{
				g.fillOval(10, STAR_Y * a + 7, 10, 10);
				for (int b = 1; b <= 5; b++)
				{
					g.fillOval(STAR_XO * b + 5, STAR_Y * a + 7, 10, 10);
				}
			}					
		    else
		    {
			    g.fillOval(25, STAR_Y * a + 7, 10, 10);
			    for (int b = 1; b <= 4; b++)
			    {
				g.fillOval(STAR_X1 * b + 25, STAR_Y * a + 7, 10, 10);
			    }
			}    
		}
		
		g.setColor(Color.BLACK);
		g.drawRect(START_X, START_Y, WIDTH, HEIGHT);	
	}
}
