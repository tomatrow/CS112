import javax.swing.JPanel;
import java.awt.FlowLayout;

public class RootPanel extends JPanel {
	public ImageScrollPanel _scrollPanel;
	public SubredditControls _controlsPanel;
	public RootPanel() {
		super();
		setLayout(new FlowLayout(FlowLayout.CENTER));
		initializePanels();
		layoutPanels();
	}
	private void initializePanels() {	
		_scrollPanel = new ImageScrollPanel();
		_controlsPanel = new SubredditControls();
	}
	private void layoutPanels() {
		add(_controlsPanel);
		add(_scrollPanel);
	}
}