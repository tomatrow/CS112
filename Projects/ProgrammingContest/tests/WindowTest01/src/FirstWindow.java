import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;

public class FirstWindow extends JFrame {
	 public static final int WIDTH = 300;
	 public static final int HEIGHT = 200;

	public FirstWindow() {
		super();
		setSize(WIDTH, HEIGHT);
		setTitle("First Window Class");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		JButton endButton = new JButton("Click to end program.");
		endButton.addActionListener(new EndingListener());
		JTextPane textPane = new JTextPane();
		JEditorPane editorPane = new JEditorPane();
		editorPane.setEditorKit(JEditorPane.createEditorKitForContentType("text/html"));

		
		// add(textPane);
		// add(endButton);
		add(editorPane);
	}
}