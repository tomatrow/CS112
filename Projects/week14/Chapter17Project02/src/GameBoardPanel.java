import java.awt.GridLayout;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.util.ArrayList;
import java.awt.event.ActionListener;

public class GameBoardPanel extends JPanel {
	public static final String X = "X";
	public static final String O = "O";
	public static final String SPACE = " ";


	public ArrayList<JButton> _gameButtons;
	public final int _edgeSize;
	private ActionListener _delegate;

	public GameBoardPanel(int edgeSize, ActionListener delegate) {
		super();
		_edgeSize = edgeSize;
		setLayout(new GridLayout(_edgeSize,_edgeSize));
		_delegate = delegate;

		buildPanel();
	}
	private void buildPanel() {
		int arraySize = _edgeSize * _edgeSize;
		_gameButtons = new ArrayList<JButton>(arraySize);

		for (int y = 0;y < _edgeSize;y++) {
			for (int x = 0;x < _edgeSize;x++) {
				JButton button = new JButton(SPACE);
				button.addActionListener(_delegate);
				button.setActionCommand(x + ":" + y);
				_gameButtons.add(button);
				add(button);
			}
		}
	}
	public void reset() {
		for (int x = 0;x < _gameButtons.size();x++) {
			_gameButtons.get(x).setText(SPACE);
		}
	}
}