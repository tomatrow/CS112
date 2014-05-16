import javax.swing.JFrame;
import javax.swing.Action;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

public class MainPanel extends JFrame {
	public MainPanel() {
		super();

		Dimension frameSize = new Dimension(170, 100);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(frameSize);
		setMinimumSize(frameSize);

		buildInterface();

		setLocationRelativeTo(null); 
		setVisible(true);
	}
	private void buildInterface() {
		JLabel label = new JLabel("Hello world");
		add(label);
		setJMenuBar(new MenuBar(new BorderActionListener(getRootPane(),label)));
	}
}
