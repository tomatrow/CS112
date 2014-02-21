/**
 * @(#)ChessBoard.java
 * 1. Draw chessboard outline ( 40 pixels squares - 8 x 8 = 320x320 shape
 * 2. White square in top corner - squares have to alternate
 * 3. Nested loops - one places all boxes on horizontal line, and one that
 *    contains a forloop that increments every time it reaches the 8th 
 *    square.
 * 4. If statement that checks whether or not the vertical line is even - 
 *    even lines start on black, odd lines start on white.
 * 5. On the horizontal if statement, it should only draw the black 
 *    squares as drawing the white ones would be redundant.
 */
 
 
import java.awt.*;
import javax.swing.JApplet;

public class ChessBoard extends JApplet
{
	public void paint(Graphics chess)
	{
		int horiz = 1, vert = 1, even;
		chess.drawRect(40,40,320,320);
		
		for (vert = 1; vert <= 8; vert++)
		{
			if (vert % 2 == 0)
				even = 1;
			else even = 2;
			
			for (horiz = even; horiz <= 8; horiz += 2)
			{
				chess.fillRect(horiz * 40, vert * 40, 40, 40);
			}
		}
	}	

}
