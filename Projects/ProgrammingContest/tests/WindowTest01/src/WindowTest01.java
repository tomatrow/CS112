import java.awt.*;
import javax.swing.JFrame;



public class WindowTest01 {
	public static final int WIDTH = 300;
	public static final int HEIGHT = 200;

	public static void main(String[] args) {
		JFrame firstWindow = new FirstWindow();

		firstWindow.setVisible(true);
	}
}