// CreativeFigures.java
// Student: Jessica White
// Feb. 1, 2011

// This program creates a cone, a rectangle, and an oval with
// different colors.
 
import javax.swing.*;
import java.awt.*;

public class CreativeFigures extends JApplet 
{
	public void paint(Graphics g) 
	{
		// Fill the background
		g.setColor(Color.MAGENTA);
		g.fillRect(5,5,500,500);
				
		// Fill and draw Circles
		g.setColor(Color.BLACK);
		g.fillOval(50,50,150,150);
		g.drawOval(50,50,150,150);
		g.setColor(Color.BLUE);
		g.fillOval(75,75,125,125);
		g.setColor(Color.BLACK);		
		g.drawOval(75,75,125,125);
		g.setColor(Color.GREEN);
		g.fillOval(100,100,100,100);
		g.setColor(Color.BLACK);		
		g.drawOval(100,100,100,100);
		g.setColor(Color.RED);
		g.fillOval(125,125,75,75);
		g.setColor(Color.BLACK);		
		g.drawOval(125,125,75,75);
		g.setColor(Color.ORANGE);
		g.fillOval(150,150,50,50);
		g.setColor(Color.BLACK);		
		g.drawOval(150,150,50,50);
		g.setColor(Color.YELLOW);
		g.fillOval(175,175,25,25);
		g.setColor(Color.BLACK);		
		g.drawOval(175,175,25,25);
		
        // Fill and draw Squares
		g.setColor(Color.BLACK);
		g.fillRect(300,50,150,150);
		g.drawRect(300,50,150,150);
		g.setColor(Color.BLUE);
		g.fillRect(290,60,125,125);
		g.setColor(Color.BLACK);		
		g.drawRect(290,60,125,125);
		g.setColor(Color.GREEN);
		g.fillRect(280,70,100,100);
		g.setColor(Color.BLACK);		
		g.drawRect(280,70,100,100);
		g.setColor(Color.RED);
		g.fillRect(270,80,75,75);
		g.setColor(Color.BLACK);		
		g.drawRect(270,80,75,75);
		g.setColor(Color.ORANGE);
		g.fillRect(260,90,50,50);
		g.setColor(Color.BLACK);		
		g.drawRect(260,90,50,50);
		g.setColor(Color.YELLOW);
		g.fillRect(250,100,25,25);
		g.setColor(Color.BLACK);		
		g.drawRect(250,100,25,25);
		
		// Fill and draw Ovals
		g.setColor(Color.GREEN);
		g.fillOval(200,300,200,150);
		g.setColor(Color.BLACK);		
		g.drawOval(200,300,200,150);
		g.setColor(Color.ORANGE);
		g.fillOval(210,290,175,125);
		g.setColor(Color.BLACK);		
		g.drawOval(210,290,175,125);
		g.setColor(Color.RED);
		g.fillOval(220,280,150,100);
		g.setColor(Color.BLACK);		
		g.drawOval(220,280,150,100);
		g.setColor(Color.YELLOW);
		g.fillOval(230,270,125,75);
		g.setColor(Color.BLACK);		
		g.drawOval(230,270,125,75);
		g.setColor(Color.BLUE);
		g.fillOval(240,260,100,50);
		g.setColor(Color.BLACK);		
		g.drawOval(240,260,100,50);
		g.fillOval(250,255,75,35);
		g.drawOval(250,255,75,35);		
				
	}
}
