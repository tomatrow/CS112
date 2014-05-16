import javax.swing.JFrame;
import java.awt.Dimension;

public class MainFrame extends JFrame {
	public RootPanel _rootPanel;
	public static final int HEIGHT = 500;
	public static final int WIDTH = 350;
	public Controller _controller;
	public MainFrame(Controller controller) {
		super();
		setup();
		_controller = controller;
		_rootPanel = new RootPanel();
		setContentPane(_rootPanel);
		// pack();
		setVisible(true);
		_controller.onVisible(this);
	}

	private void setup() {
		setTitle("RedditImageScraper");
		setSize(new Dimension(WIDTH,HEIGHT));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null); // Center window
	}
}
