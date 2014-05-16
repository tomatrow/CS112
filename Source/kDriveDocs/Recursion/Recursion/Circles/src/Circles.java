import javax.swing.*;
import java.awt.*;

/**
 *  This applet uses a recursive method to draw
 *  concentric circles. 
 */

public class Circles extends JApplet
{
   /**
    *  init method
    */
   
   public void init()
   {
      // Set the background color to white.
      setBackground(Color.WHITE);
   }
   
   /**
    *  paint method 
    */
   
   public void paint(Graphics g)
   {
      // Draw 10 concentric circles. The outermost circle's
      // enclosing rectangle should be at (5, 5), and it
      // should be 300 pixels wide by 300 pixels high.
      drawCircles(g, 10, 5, 300);
   }

   /**
    * The drawCircles method draws concentric circles.
    * It accepts the following arguments:
    * g, a Graphics object
    * n, the number of circles to draw
    * topXY, the top left coordinates of the
    *        outermost circle's enclosing rectangle
    *        size, the width and height of the outermost
    *        circle's enclosing rectangle
    */
      
   private void drawCircles(Graphics g, int n, int topXY, int size)
   {  
      if (n > 0)
      {
         g.drawOval(topXY, topXY, size, size);
         drawCircles(g, n - 1, topXY + 15, size - 30);
      }
   }
}