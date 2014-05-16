// This class demonstrates what can be done with a GUI by producing 
// multiple circles each getting bigger and moving toward the user
// while changing colors.

import java.awt.*;
import javax.swing.*;

class DrawCircles2 extends JFrame
{
	public static void main(String[] args)
	{
		DrawCircles2 app = new DrawCircles2();
	}
	public DrawCircles2() 
	{
		setBounds(150, 50, 500, 500);
		setTitle("Drawing Circles with Random Colors");
		setResizable(false);
		setVisible(true);
		
		Container c = getContentPane();
		c.setBackground(Color.white);
		Graphics g = getGraphics();
		while (true)
			drawCircles(g);
	}
	
	private void drawCircles(Graphics graphics)
	{
		Color fillColor = Color.white;
		int r, g, b, upperX, upperY, width, height;
		
		graphics.setColor(fillColor);
		graphics.fillRect(0, 0, 500, 500);
		for (int i = 1; i <= 50; i++)
		{
			r = getColorVal();
			g = getColorVal();
			b = getColorVal();
			fillColor = new Color(r, g, b);
			graphics.setColor(fillColor);
			
			width = 10 + 8 * i;
			height = 10 + 8 * i;			
			upperX = 250 - width/2;
			upperY = 250 - height/2;

			graphics.fillOval(upperX, upperY, width, height);
			try
			{
				Thread.sleep(50);
			}
			catch (Exception e)
			{
			}
		}
	}	
	
	private int getColorVal()
	{
		return (int)(Math.random() * 256);
	}		
}