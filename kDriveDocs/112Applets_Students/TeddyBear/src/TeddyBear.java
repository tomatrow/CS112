//TeddyBear.java
// Designers: Natty Tangjitportchai
//            Billy Nolan
 
import java.awt.*;
import java.applet.*;

public class TeddyBear extends Applet
{	
	public void paint(Graphics g)
	{
		g.drawString("My Teddy Bear!!", 50, 60 );
		
		//draw Head
		g.setColor(Color.CYAN);
		g.fillOval(200, 50, 200, 200);		
					
		//draw Body
		g.setColor(Color.CYAN);
		g.fillOval(250, 160, 100, 50);
		g.fillOval(100, 200, 400, 400);
		
		//draw Eyes
		g.setColor(Color.BLACK);
		g.fillOval(255, 100, 15, 15);
		g.fillOval(330, 100, 15, 15);
		//draw Nose
		g.setColor(Color.BLACK);
		g.fillOval(292, 150, 20, 10);
		//draw Ears
		g.setColor(Color.BLACK);
		g.drawArc(164, 25, 80, 80, 0, 270);
		g.drawArc(350, 25, 80, 80, 270, 270);
		//draw inside ears
		g.setColor(Color.BLACK);
		g.drawArc(185, 50, 40, 40, 0, 270);
		g.drawArc(371, 50, 40, 40, 270, 270);
		//draw smile
		g.setColor(Color.RED);
		g.drawArc(250, 160, 100, 50, 180, 180);

		//draw arms
		g.setColor(Color.BLACK);
		g.drawArc(60, 280, 100, 100, 60, 200);
		g.drawArc(440,280, 100, 100, 280, 200);
		//draw feet
		g.setColor(Color.BLACK);
		g.drawArc(164, 530, 100, 100, 150, 190);
		g.drawArc(350, 530, 100, 100, 195, 210);

		//draw tummy
		g.setColor(Color.BLACK);
		g.drawArc(150, 350, 300, 300, 345, 210);

		//draw bow tie
		g.setColor(Color.YELLOW);
		g.fillOval(260, 255, 45, 50);
		g.fillOval(300, 255, 45, 50);
		g.setColor(Color.ORANGE);
		g.fillOval(292, 270, 20, 20);
				
		//outline head
		g.setColor(Color.BLACK);
		g.drawOval(200, 50, 200, 200);
								
		//outline body
		g.drawArc(100, 200, 400, 400, 112, 316);

		//outline bow tie parts
		g.drawOval(292, 270, 20, 20);		
		g.drawArc(260, 255, 45, 50, 25, 315);
		g.drawArc(300, 255, 45, 50, 202, 310);								
	}
}
