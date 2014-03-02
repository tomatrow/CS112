// Flower.java
// Leslie MacAulay
 
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JApplet;

public class Flower extends JApplet
{	
	public void paint(Graphics flower)
	{
	    // Set leaf color
	    flower.setColor(Color.GREEN);
	    // Draw outside right arc for leaf  
	    flower.drawArc(100,90,170,200,270,180);
	    flower.drawArc(99,90,170,200,270,180);
	    flower.drawArc(98,90,170,200,270,180);
	    flower.drawArc(97,90,170,200,270,180);
	    flower.drawArc(96,90,170,200,270,180);
	    flower.drawArc(95,90,170,200,270,180);
	    flower.drawArc(94,90,170,200,270,180);
	    flower.drawArc(93,90,170,200,270,180);
	    
	    // Draw outside left arc for leaf
	    flower.drawArc(164,139,170,200,90,120);
	    flower.drawArc(163,139,170,200,90,120);
	    flower.drawArc(162,139,170,200,90,120);
	    flower.drawArc(161,139,170,200,90,120);
	    flower.drawArc(160,139,170,200,90,120);
	    flower.drawArc(159,139,170,200,90,120);
	    flower.drawArc(158,139,170,200,90,120);
	    
	    // Set flower color for outer petals
	    flower.setColor(Color.MAGENTA);
	    // Fill outer petals with color
	    flower.fillOval(175,16,70,70);
	    flower.fillOval(130,55,70,70);
	    flower.fillOval(145,110,70,70);
	    flower.fillOval(205,125,70,70);
	    flower.fillOval(245,86,70,70);
	    flower.fillOval(234,32,70,70);
	    
	    // Set flower color for inner petals
	    flower.setColor(Color.PINK);
	    // Fill inner petals with color
	    flower.fillOval(193,40,50,50);
	    flower.fillOval(160,70,50,50);
	    flower.fillOval(170,110,50,50);
	    flower.fillOval(210,120,50,50);
	    flower.fillOval(240,90,50,50);
	    flower.fillOval(230,53,50,50);
	    
	    // Set color, draw center ring
	    // Fill with color
	    flower.setColor(Color.ORANGE);
	    flower.fillOval(194,74,62,62);
	    
	    // Set color, draw another center ring
	    // Fill with color which overlaps part
	    // of the previous ring
	    flower.setColor(Color.YELLOW);
	    flower.fillOval(200,80,50,50);
	    
	    // Set color for LadyBug legs
	    // Draw legs with designated color
	    flower.setColor(Color.BLACK);
	    flower.drawLine(300,50,290,65);
	    flower.drawLine(305,50,297,69);
	    flower.drawLine(310,50,305,73);
	    flower.drawLine(300,40,290,23);
	    flower.drawLine(305,40,296,20);
	    flower.drawLine(310,40,306,20);
	    
	    // Set color for LadyBug Body
	    // Draw body and fill with color
	    flower.setColor(Color.RED);
	    flower.fillOval(285,25,40,40);
	    
	    // Set color for LadyBug Head and Dots	    
	    flower.setColor(Color.BLACK);
	    // Draw head and fill with color	    
	    flower.fillOval(268,35,20,20);
	    // Draw and fill Dots on LadyBug's body	    
	    flower.fillOval(290,36,7,7);
	    flower.fillOval(299,31,7,7);
	    flower.fillOval(310,34,7,7);
	    flower.fillOval(304,43,7,7);
	    flower.fillOval(291,49,7,7);
	    flower.fillOval(306,51,7,7);
	    flower.fillOval(313,47,7,7);
	    
	    // Draw LadyBug Antennas
	    flower.drawLine(264,32,269,39);
	    flower.drawLine(262,50,269,44);	    
	}
}
