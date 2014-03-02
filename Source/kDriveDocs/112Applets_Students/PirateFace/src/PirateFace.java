// This applet creates a Pirate Face.

import javax.swing.JApplet;
import java.awt.Graphics;
import java.awt.Color;

public class PirateFace extends JApplet
{
	public void paint(Graphics canvas)
	{
		// fill the colors for the pirate's face
	    canvas.setColor(Color.YELLOW);
	    canvas.fillOval(100,50,200,200);
	    
	    // draw the face
	    canvas.setColor(Color.BLACK);
	    canvas.drawOval(100,50,200,200);
	    canvas.fillOval(230,100,10,20);
	    canvas.drawArc(150,190,100,50,180,-180);
	    
	    // draw the eye patch
	    canvas.drawLine(116,95,284,95);  // string
	    canvas.fillOval(145,95,40,40);   // eye patch
	    
	    // draw the scar
	    canvas.setColor(Color.RED);
	    canvas.drawLine(100,145,140,185);
	    
	    // create a variable for the stitches
	    int stitch = 0;
	    
	    // for loop that will create the stitches
	    for (int scar = 0; scar < 5; scar++)
	    {
	    	stitch +=5;
	    	canvas.drawLine((stitch+100),(stitch+150),(stitch+110),(stitch+150));	    	
	    }
	    
	    // reset color to black
	    canvas.setColor(Color.BLACK);
	    
	    // create a variable for each beard bristle and size
	    int bristle = 0;
	    int beardLength = 0;
	    int cut = 0;
	    
	    // for loop that will add his beard
	    for (int beard = 0; beard < 17; beard++)
	    {
	    	bristle +=10;
	    	beardLength++;
	    	
	    	// manipulate the size of the beard
	    	if (beardLength <= 9)
	    	{
	    		canvas.drawLine(110+bristle,200,110+bristle,200+bristle);	    		
	    	}
	    	
	    	// cut the other side of the beard to be symmetric
	    	
	    	if (beardLength > 9)
	    	{
	    		cut +=20;
	    		canvas.drawLine((110+bristle),200,(110+bristle),(200+bristle-cut));
	    	}
	    }
    		
	}
}