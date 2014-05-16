import javax.swing.JFrame;
import java.awt.GridLayout;

public class MainPanel extends JFrame {
	private StatusPanel _statusPanel;
	private ComputePanel _computePanel;
	private DependentsPanel _dependentsPanel;

	public MainPanel() {
		super();
		setLayout(new GridLayout(1,3));

		// buildPanel();

		// add(_statusPanel);
		// add(_computePanel);
		// add(_dependentsPanel);
	}
	private void buildPanel() {
		_statusPanel = new StatusPanel();
		_computePanel = new ComputePanel();
		_statusPanel = new StatusPanel();
	}
}