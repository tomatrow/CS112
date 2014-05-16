import java.awt.GridLayout;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.util.ArrayList;
import java.awt.event.ActionListener;

public class OperatorPane  extends JPanel { 
	public ArrayList<JButton> _operatorButtons;
	private ActionListener _delegate;
	public static final String[] operatorStrings = {"+","-","/","*"};

	public OperatorPane(ActionListener delegate) {
		super();
		setLayout(new GridLayout(4,1));
		_delegate = delegate;
		buildPanel();
	}
	private void buildPanel() {
		int arraySize = operatorStrings.length;
		_operatorButtons = new ArrayList<JButton>(arraySize);
		for (int x = 0;x < arraySize;x++) {
			JButton button = new JButton(operatorStrings[x]);
			button.addActionListener(_delegate);
			button.setActionCommand(operatorStrings[x]);
			_operatorButtons.add(button);
			add(button);
		}
	}
}